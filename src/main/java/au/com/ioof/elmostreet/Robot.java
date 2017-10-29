package au.com.ioof.elmostreet;

import au.com.ioof.elmostreet.Command.Left;
import au.com.ioof.elmostreet.Command.Move;
import au.com.ioof.elmostreet.Command.NoOp;
import au.com.ioof.elmostreet.Command.Placement;
import au.com.ioof.elmostreet.Command.Report;
import au.com.ioof.elmostreet.Command.Right;
import au.com.ioof.elmostreet.Command.Visitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.stream.Stream;

public final class Robot implements Consumer<String>, Visitor<Robot> {

    private Table table;
    private Consumer<String> reporter;

    private Position position;
    private Facing facing;

    public Robot(final Table table,
                 final Consumer<String> reporter) {
        this.table = table;
        this.reporter = reporter;
    }

    @Override
    public void accept(final String file) {
        getLines(file).map(Command::parse).forEach(command -> command.accept(this));
    }

    @Override
    public Robot visit(final Placement command) {
        if (table.contains(command.getPosition())) {
            position = command.getPosition();
            facing = command.getFacing();
        }
        return this;
    }

    @Override
    public Robot visit(final Left command) {
        if (null != position) {
            facing = facing.rotate(command);
        }
        return this;
    }

    @Override
    public Robot visit(final Right command) {
        if (null != position) {
            facing = facing.rotate(command);
        }
        return this;
    }

    @Override
    public Robot visit(final Move command) {
        if (null != position && table.contains(position.move(facing))) {
            position = position.move(facing);
        }
        return this;
    }

    @Override
    public Robot visit(final Report command) {
        if (null != position && null != facing) {
            reporter.accept(String.format("%s,%s", position, facing));
        }
        return this;
    }

    @Override
    public Robot visit(final NoOp command) {
        return this;
    }

    private Stream<String> getLines(final String file) {
        try {
            return Files.lines(Paths.get(file));
        } catch (final IOException exception) {
            return Stream.empty();
        }
    }
}
