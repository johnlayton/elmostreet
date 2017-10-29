echo "--------------------"
echo "Clone the repository"
echo "--------------------"
git clone git@github.com:johnlayton/elmostreet.git  robot

echo "------------"
echo "Test the app"
echo "------------"
pushd robot && \
  ./gradlew checkstyleMain checkstyleTest findbugsMain findbugsTest test && \
  popd

echo "-----------------"
echo "Run the scenarios"
echo "-----------------"
pushd robot && \
  ./gradlew run -Pscenarios="['./src/test/resources/scenario1.txt', \
                            './src/test/resources/scenario2.txt', \
                            './src/test/resources/scenario3.txt']" && \
  popd
