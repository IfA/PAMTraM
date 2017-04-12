/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.ExternalMappedAttributeValueAppender;
import pamtram.mapping.ExternalMappedAttributeValuePrepender;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.GlobalAttributeImporter;
import pamtram.mapping.LocalMappedAttributeValueExpander;
import pamtram.mapping.MappedAttributeValueAppender;
import pamtram.mapping.MappedAttributeValuePrepender;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingFactory;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class MappingFactoryImpl extends EFactoryImpl implements MappingFactory {

	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static MappingFactory init() {
		try {
			MappingFactory theMappingFactory = (MappingFactory) EPackage.Registry.INSTANCE
					.getEFactory(MappingPackage.eNS_URI);
			if (theMappingFactory != null) {
				return theMappingFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MappingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public MappingFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case MappingPackage.MAPPING:
			return this.createMapping();
		case MappingPackage.MAPPING_HINT_GROUP:
			return this.createMappingHintGroup();
		case MappingPackage.MAPPING_HINT_GROUP_IMPORTER:
			return this.createMappingHintGroupImporter();
		case MappingPackage.EXPORTED_MAPPING_HINT_GROUP:
			return this.createExportedMappingHintGroup();
		case MappingPackage.LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER:
			return this.createLocalMappedAttributeValueExpander();
		case MappingPackage.MAPPED_ATTRIBUTE_VALUE_PREPENDER:
			return this.createMappedAttributeValuePrepender();
		case MappingPackage.MAPPED_ATTRIBUTE_VALUE_APPENDER:
			return this.createMappedAttributeValueAppender();
		case MappingPackage.GLOBAL_ATTRIBUTE:
			return this.createGlobalAttribute();
		case MappingPackage.GLOBAL_ATTRIBUTE_IMPORTER:
			return this.createGlobalAttributeImporter();
		case MappingPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER:
			return this.createExternalMappedAttributeValuePrepender();
		case MappingPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER:
			return this.createExternalMappedAttributeValueAppender();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Mapping createMapping() {
		MappingImpl mapping = new MappingImpl();
		return mapping;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public MappingHintGroup createMappingHintGroup() {
		MappingHintGroupImpl mappingHintGroup = new MappingHintGroupImpl();
		return mappingHintGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public MappingHintGroupImporter createMappingHintGroupImporter() {
		MappingHintGroupImporterImpl mappingHintGroupImporter = new MappingHintGroupImporterImpl();
		return mappingHintGroupImporter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ExportedMappingHintGroup createExportedMappingHintGroup() {
		ExportedMappingHintGroupImpl exportedMappingHintGroup = new ExportedMappingHintGroupImpl();
		return exportedMappingHintGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public LocalMappedAttributeValueExpander createLocalMappedAttributeValueExpander() {
		LocalMappedAttributeValueExpanderImpl localMappedAttributeValueExpander = new LocalMappedAttributeValueExpanderImpl();
		return localMappedAttributeValueExpander;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public MappedAttributeValuePrepender createMappedAttributeValuePrepender() {
		MappedAttributeValuePrependerImpl mappedAttributeValuePrepender = new MappedAttributeValuePrependerImpl();
		return mappedAttributeValuePrepender;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public MappedAttributeValueAppender createMappedAttributeValueAppender() {
		MappedAttributeValueAppenderImpl mappedAttributeValueAppender = new MappedAttributeValueAppenderImpl();
		return mappedAttributeValueAppender;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public GlobalAttribute createGlobalAttribute() {
		GlobalAttributeImpl globalAttribute = new GlobalAttributeImpl();
		return globalAttribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public GlobalAttributeImporter createGlobalAttributeImporter() {
		GlobalAttributeImporterImpl globalAttributeImporter = new GlobalAttributeImporterImpl();
		return globalAttributeImporter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ExternalMappedAttributeValuePrepender createExternalMappedAttributeValuePrepender() {
		ExternalMappedAttributeValuePrependerImpl externalMappedAttributeValuePrepender = new ExternalMappedAttributeValuePrependerImpl();
		return externalMappedAttributeValuePrepender;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ExternalMappedAttributeValueAppender createExternalMappedAttributeValueAppender() {
		ExternalMappedAttributeValueAppenderImpl externalMappedAttributeValueAppender = new ExternalMappedAttributeValueAppenderImpl();
		return externalMappedAttributeValueAppender;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public MappingPackage getMappingPackage() {
		return (MappingPackage) this.getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MappingPackage getPackage() {
		return MappingPackage.eINSTANCE;
	}

} // MappingFactoryImpl
