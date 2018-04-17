# PAMTraM Casestudy: AutoProbe

This casestudy is one of the results of the AutoProBe research project which targeted the integrated design of human-machine interfaces for production plants. The results of the AutoProBe project are among others published [here](http://dx.doi.org/10.1109/ETFA.2015.7301550). This casestudy implements the transformation between the *Basic Panel Setup* and the *Concrete HMI Model* phases of the developed workflow.

## Additional Information and Resources

The source modeling language of the transformation is *STGML* - an extension of the Statechart Modeling Language [SCXML] that allows to attach visualization layers to states.

The target modeling language of the transformation is *Movisa* - a modeling language for industrial UIs that was created by Stefan Henning during his time at the [Institute of Automation at TU Dresden][Institute of Automation]. The Movisa language is described in detail in his [PhD thesis](http://www.vogtverlag.de/buecher/9783938860496.html). 

During the transformation, library entries that are based on the *MovisaLibrary* - an extension of the [GenLibrary](https://git.agtele.eats.et.tu-dresden.de/agtele/de.tud.et.ifa.agtele.genlibrary) for Movisa - are inserted into the target model.

**Note:** Due to copyright reasons, both the Movisa metamodel and the MovisaLibrary cannot be distributed freely. Thus, this casestudy cannot be executed out of the box. For enquiries about the additionally required ressources, please contact [Matthias Freund](mailto:matthias.freund@tu-dresden.de) or any other member of the [Institute of Automation].


[SCXML]: https://www.w3.org/TR/scxml/
[Institute of Automation]: http://www.et.tu-dresden.de/ifa