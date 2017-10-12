# Using GenTrans outside Eclipse

This is a simple demonstration on how to perform a GenTrans transformation without relying on any deployed Eclipse plugins resp. on a running Eclipse instance itself.

Therefore, the file ``StandaloneGenTransRunner.java`` provides an (almost) MWE on how to transform a given source model using a given PAMTraM model.

## Prerequisites

The current version of all required JARs need to be present in the ``lib`` folder.

In order to update those JARs, the following steps need to be performed from within a running Eclipse instance.

- Import this project as well as the ``de.mfreund.gentrans.standalone.feature`` project into the workspace.
- Run the ant script ``export1.xml`` that will export the ``gentrans.standalone.feature`` to the ``temp`` folder of this project.
- After the ``temp`` folder has been populated with the exported plugins, run the ant script ``export2.xml``.

Note: Both ant scripts have to be run in the same JRE as the workspace.

## Run a transformation from within Eclipse

If the required JARs have been updated (see above), the build path of the Eclipse project has to be updated. Therefore, go to ``Right Click -> Build Path -> Configure Build Path... -> Libraries``, delete all missing JARs and add all JARs from the ``lib`` folder.

Run the launch configuration file ``RunTransformation.launch`` that calls the ``StandaloneGenTransRunner`` to transformation the source model ``sample-models/source-model.xmi`` via the PAMTraM model ``sample-models/pamtram-model.pamtram`` and stores the result in the file ``sample-models/target-model.xmi``.

## Run a transformation from the command line

First, compile the ``StandaloneGenTransRunner`` via the command line as follows (assuming you are located in the root folder of this project):

``javac  -d bin -cp lib/* .\src\de\mfreund\gentrans\transformation\standalone\StandaloneGenTransRunner.java``

Run the compiled class as follows to transformation the source model ``sample-models/source-model.xmi`` via the PAMTraM model ``sample-models/pamtram-model.pamtram`` and stores the result in the file ``sample-models/target-model.xmi`` (again assuming you are located in the root folder of this project):

``java -cp "lib/*;./bin" de.mfreund.gentrans.transformation.standalone.StandaloneGenTransRunner "%cd%\sample-models\pamtram-model.pamtram" "%cd%\sample-models\source-model.xmi" "%cd%\sample-models"``

Note that absolute paths are required as parameters for the runner!