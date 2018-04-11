# PAMTraM 

PAMTraM is an Eclipse- and [EMF][]-based modeling workbench that allows developing and running model-to-model transformations between arbitrary source and target modeling languages. It originated from the PhD thesis of Matthias Freund that is available [here](http://nbn-resolving.de/urn:nbn:de:bsz:14-qucosa-229173) (German) and was developed during his time at the [Institute of Automation at TU Dresden](http://www.et.tu-dresden.de/ifa).

## Installation

### User Setup

If you just want to use PAMTraM as is in order to develop and run model-to-model transformations, you can install the current version into your Eclipse instance via the [Update Site].

### Development Setup

If you want to extend PAMTraM, you should make use of the [Setup File] for the [Eclipse Installer] that will automatically:

 * Install all required Eclipse features
 * Clone the PAMTraM, [GenLibrary](#genlibrary), and [Eclipse Commons](#eclipse-commons) Git repositories
 * Import all projects
 * Add the imported projects to working sets
 * Adjust a couple of settings in the Eclipse installation

In order to execute the installer, perform the following steps:

 * Download and execute the [Eclipse Installer]
 * Switch to the *Advanced Mode* (via the hamburger icon at the upper right of the installer)
 * Choose the *Eclipse Modeling Tools* version (any other version should work as well)
 * Add the *PAMTraM* project by 
    * clicking the small, green '**+**' icon, 
    * entering the URL of the Setup File ([https://agtele.eats.et.tu-dresden.de/eclipse/setups/PAMTraM.setup][Setup File]),
    * confirming with *OK* and 
    * selecting the new project with a *double click*
 * Specify the relevant variables on the next screen (especially the install and clone locations)
 * Execute the installer

 After the installer finished successfully, you should be good to go...

## Sub-Projects

### Eclipse Workbench

 * The **PAMTraM Projects** provide an implementation of the PAMTraM modeling language for mapping models and associated tools. 
    *  The **Model Project** defines the core language model.<br/> See [Model Project Readme](./plugins/de.mfreund.pamtram.model/README.md)
    *  The **Edit Project** provides edit support for PAMTraM that is among others required by the editor.<br/> See [Edit Project Readme](./plugins/de.mfreund.pamtram.edit/README.md)
    *  The **Editor Project** defines the Eclipse-based editor for PAMTraM.<br/> See [Edit Project Readme](./plugins/de.mfreund.pamtram.editor/README.md)
    *  The **Generator Project** realizes a generator allowing to semi-automatically generate parts of mapping models based on existing source/target models.<br/> See [Generator Project Readme](./plugins/de.mfreund.pamtram.generator/README.md)
    *  The **PAMTraM Project** provides non-UI related features to integrate with the Eclipse workbench like a *nature* definition in order.<br/> See [PAMTraM Project Readme](./plugins/de.mfreund.pamtram/README.md)
    *  The **PAMTraM UI Project** provides UI-related features to integrate with the Eclipse workbench such as *model wizards*, a *perspective* and a *preference page*.<br/>  See [UI Project Readme](./plugins/de.mfreund.pamtram.ui/README.md)

 *  The **GenTrans Projects** provide the implementation of the generic transformation algorithm and associated tools.
    *  The **Transformation Project** contains the actual implementation of the generic transformation algorithm.<br/> See [Transformation Readme](./de.mfreund.gentrans.transformation/README.md)
    *  The **Ambiguity Resolving Strategy Projects** provides several strategies that can be used to resolve ambiguities that occur during an execution of the transformation
        *  The **User Strategy Project** provides a strategy based on user interaction.<br/> See [User Strategy Readme](./de.mfreund.gentrans.transformation.selectors/README.md)
        *  The **History Strategy Project** provides a strategy based on reusing previous transformations.<br/> See [History Strategy Readme](./de.mfreund.gentrans.transformation.resolving.history/README.md)
        *  The **Statistics Strategy Project** provides a strategy based statistical evaluations.<br/> See [Statistics Strategy Readme](./de.mfreund.gentrans.transformation.resolving.statistics/README.md)
    *  The **Transformation UI Project** provides UI-related features to integrate the transformation with the Eclipse workbench such as a *job* for launching a transformation.<br/> See [Transformation UI Readme](./de.mfreund.gentrans.transformation.ui/README.md)
    *  The **UI Project** provides UI-related features to allow a user to configure/start transformations from within the Eclipse workbench such as a *launch configuration*.<br/> See [UI Readme](./de.mfreund.gentrans.ui/README.md)

### Development Features

*  The **Feature Project** provides the PAMTraM Eclipse Feature consisting of the projects that can be deployed as Plugins to an Eclipse.<br/> See [Feature Project Readme](./features/de.mfreund.pamtram.feature/README.md)
*  The **Examples Feature Project** provides the feature providing access to the various casestudies for PAMTraM once installed.<br/> See [Examples Feature Project Readme](./features/de.mfreund.pamtram.examples.feature/README.md)
*  The **Examples Project** provides tools for provisioning the various casestudies so that they can be used by the *Examples Feature Project* .<br/> See [Examples Project Readme](./plugins/de.mfreund.pamtram.examples/README.md)
*  The **Update Site Project** provides the Eclispe update site definition in order to build the installable plugins using the feature projects.<br/> See [Update Site Project Readme](./plugins/de.mfreund.pamtram.update-site/README.md)
*  The **Setup Project** provides the setup file that allows a quick start for developers by using the Eclipse Installer.<br/> See [Setup Project Readme](./plugins/de.mfreund.pamtram.setup/README.md)
*  The **Casestudy Tests Project** provides a set of tests for PAMTraM that are based on running the casestudies and comparing the actual to the expected results.<br/> See [Casestudy Tests Project Readme](./tests/de.mfreund.gentrans.test.casestudies/README.md)

### Standalone Application

*  The **Standalone Transformation Project** helping with standalone execution of GenTrans transformation, i.e. execution that does not require a running Eclipse.<br/> See [Examples Feature Project Readme](./standalone/de.mfreund.gentrans.transformation.standalone/README.md)
*  The **Standalone Feature Project** defining the all plugins required for standalone execution of GenTrans transformations.<br/> See [Examples Feature Project Readme](./standalone/de.mfreund.gentrans.standalone.feature/README.md)

### Casestudies
*  [AML-OPC UA](./casestudies/aml-opc-ua/README.md)
*  [AutoProbe](./casestudies/de.mfreund.pamtram.casestudies.autoprobe/README.md)
*  [AutoProbe Simplified](./casestudies/de.mfreund.pamtram.casestudies.autoprobe-simplified-diss/README.md)
*  [Company-Visualization](./casestudies/de.mfreund.pamtram.casestudies.company-viz/README.md)
*  [CTT-Amino Light](./casestudies/de.mfreund.pamtram.casestudies.ctt-aminolight/README.md)
*  [Disl-Movisa](./casestudies/de.mfreund.pamtram.casestudies.disl-movisa/README.md)
*  [Excel-Movisa TDP](./casestudies/de.mfreund.pamtram.casestudies.excel-movisa-tdp/README.md)
*  [Library](./casestudies/library/README.md)
*  [Models2016 Paper](./casestudies/de.mfreund.pamtram.casestudies.models2016/README.md)
*  [Visu+](./casestudies/de.mfreund.pamtram.casestudies.visu-plus/README.md)
*  [W3CAUI-Movisa](./casestudies/de.mfreund.pamtram.casestudies.w3caui-movisa/README.md)
*  [DFD-UML Activity Diagrams](./casestudies/dfd-uml/README.md)

## Related Projects

### Eclipse Commons
The AGTele Eclipse Commons Project contains several features that facilitate working with Eclipse and EMF. PAMTraM makes extensive use of many of those features throughout almost all of its sub-projects.

See [Eclipse Commons Project](https://git.agtele.eats.et.tu-dresden.de/agtele-public/de.tud.et.ifa.agtele.eclipse.commons)

### GenLibrary
The AGTele GenLibrary Project provides a generic (base) implementation for a model-based library system for MBUID. PAMTraM integrates GenLibrary so that conforming library entries can be integrated into a model transformation, i.e. instantiated in the course of the transformation.

See [GenLibrary Project](https://git.agtele.eats.et.tu-dresden.de/agtele/de.tud.et.ifa.agtele.genlibrary)

[EMF]: https://www.eclipse.org/modeling/emf/
[Eclipse Installer]: https://www.eclipse.org/downloads/eclipse-packages/
[Update Site]: https://agtele.eats.et.tu-dresden.de/eclipse/updates/
[Setup File]: https://agtele.eats.et.tu-dresden.de/eclipse/setups/PAMTraM.setup