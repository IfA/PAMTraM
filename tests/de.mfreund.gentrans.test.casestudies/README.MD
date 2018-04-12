# Casestudy Test

This project contains a set of JUnit test cases. Each of the test cases will execute a transformation (one of the casestudies) and compare the actual result with the expected result (stored in the [./expected-results](./expected-results)) folder.

## Running the tests

### Preconditions

The tests rely on the PAMTraM plugins being installed. In order to ensure that the latest versions of all PAMTraM-related plugins are tested, they will be executed as 'JUnit Plug-in Tests' in a runtime Eclipse instance. Thus, before the tests can be run successfully, ensure that

 * the workspace `${workspace_loc}/../runtime-PAMTraM` exists,
 * the project `de.mfreund.gentrans.test.casestudies` is imported into the workspace, and
 * all projects from the [casestudies](../../casestudies) folder are imported into the workspace.

### Execution

In order to run the tests, just launch the file `AllCasestudyTests-AsPluginTest.launch`.