package pamtram.converter;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import pamtram.commands.GenericConvertCommand.IConverter;
import pamtram.structure.InstanceSelectorExternalSourceElement;
import pamtram.structure.InstanceSelectorSourceElement;
import pamtram.structure.StructurePackage;

/**
 * An {@link IConverter} that is able to convert a normal {@link AttributeMatcherSourceElement} to an
 * {@link AttributeMatcherExternalSourceElement}.
 *
 * @author mfreund
 */
public class InternalToExternalSourceAttrMatcherElementConverter
		implements IConverter<InstanceSelectorSourceElement, InstanceSelectorExternalSourceElement> {

	@Override
	public InstanceSelectorExternalSourceElement convert(InstanceSelectorSourceElement source) {

		EPackage ePackage = source.eClass().getEPackage();
		InstanceSelectorExternalSourceElement target = (InstanceSelectorExternalSourceElement) ePackage
				.getEFactoryInstance()
				.create((EClass) ePackage.getEClassifier("ComplexAttributeMatcherExternalSourceElement"));

		if (source.getName() != null) {
			target.setName(source.getName());
		}

		if (source.getSource() != null) {
			target.setSource(source.getSource());
		}

		if (source.getModifiers() != null) {
			target.eSet(
					target.eClass().getEStructuralFeature(
							StructurePackage.INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT__MODIFIERS),
					source.getModifiers());
		}

		return target;
	}
}