# PAMTraM Casestudy: AML-OPC-UA

A casestudy that implements a transformation between AutomationML (AML) files and OPC UA Nodeset XML files according to the transformation rules described in [DIN SPEC 16592][].

## Additional Information and Resources

[AutomationML][] files are specified using the [CAEX metamodel][CAEX-metamodel] that is defined by IEC 62424. This transformation supports version 2.15 of the CAEX metamodel.

The OPC UA NodetsetXML format is specified in Annex B of [Part 6 of the OPC UA specification][opc-ua-spec-part-6]. The XSD can be obtained at http://www.opcfoundation.org/UA/schemas/1.02/Opc.Ua.NodeSet2.xml.

## Project Structure

**amlMetaModel**: A git submodule containing the EMF-based AML/CAEX metamodel provided at [amlModeling][AML-metamodel]. Moreover, this contains a converter that is able to convert AML files conforming to the CAEX XSD into AML files conforming to the EMF-based metamodel. 

**de.mfreund.pamtram.casestudies.aml-opc-ua**: The PAMTraM project for the transformation from AML to OPC UA.

**opc-ua-server**: A simple [NodeJS][] server that builds its adress space from an OPC UA NodesetXML file using the [node-opcua][] module.

## Usage

1. **Preparing the source model(s)**<br />
  The PAMTraM model supports source models that conform to the EMF-based [AML metamodel][AML-metamodel]. This is [based on but not 100% compatible to](https://github.com/amlModeling/amlMetaModel/blob/master/README.md) the CAEX XSD. Consequently, new *aml* files to be transformed that conform to the XSD have to be converted into *xmi* files that conform to the EMF-based metamodel first.<br />
  To do this, the `AML2XMIConverter` that can be found in `de.mfreund.pamtram.casestudies.aml-opc-ua\src\amlToXmi` can be used (see documentation in the Java file for usage hints).

2. **Run the transformation**<br />
  Based on the created *xmi* file(s) and the provided *aml-opc-ua.pamtram* model, a transformation can be executed. This does not differ from any of the other casestudies.

3. **Run the OPC UA server**<br />
  In order to demonstrate the result of the transformation, the simple OPC UA server (see above) can be used. To start the server, just start a command line and run `node .\opcua.js` in the `opc-ua-server` folder (obviously, you will need to have [NodeJS][] installed first). The server will provide an OPC UA endpoint at the URL `opc.tcp://<name-of-your-pc>:26543`<br />
  By default, the file `AMLUANodeSet.xml` in the `Target` folder of the PAMTraM project will be used to build the address space. However, other files can be configure in the file `opcua.js`.


[AutomationML]: https://www.automationml.org/
[AML-metamodel]: https://github.com/amlModeling/amlMetaModel
[CAEX-metamodel]: http://www.plt.rwth-aachen.de/cms/PLT/Forschung/Projekte2/~ejwy/CAEX-IEC-62424/
[DIN SPEC 16592]: https://www.beuth.de/de/technische-regel/din-spec-16592/265597431
[NodeJS]: https://nodejs.org/
[node-opcua]: https://github.com/node-opcua
[opc-ua-spec-part-6]: https://opcfoundation.org/developer-tools/specifications-unified-architecture/part-6-mappings/