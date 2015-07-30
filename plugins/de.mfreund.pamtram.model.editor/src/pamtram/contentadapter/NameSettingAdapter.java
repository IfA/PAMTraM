package pamtram.contentadapter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import pamtram.NamedElement;
import pamtram.PamtramPackage;
import pamtram.metamodel.Class;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.Reference;

/**
 * This will probably be handled by the generated model code in the future.
 * 
 * @author mfreund
 */
@Deprecated
final class NameSettingAdapter extends PamtramChildContentAdapter {

	public NameSettingAdapter(PamtramContentAdapter parentAdapter) {
		super(parentAdapter);
	}

	@Override
	public void notifyChanged(Notification n) {
		super.notifyChanged(n);

		if(n.getEventType() == Notification.RESOLVE) {
			return;
		}

		// find out the type of the notifier
		Object notifier = n.getNotifier();

		// handle notifications by notifier type
		if(notifier instanceof Reference) {
			handleReferenceNotification(n);
		} else if(notifier instanceof pamtram.metamodel.Class) {
			handleClassNotification(n);
		}

	}

	// A ContainmentReference has issued a notification.
	private void handleReferenceNotification(Notification n) {

		// the notifying reference
		Reference<?,?,?> ref = (Reference<?,?,?>) n.getNotifier();

		if (n.getFeature() == MetamodelPackage.Literals.CONTAINMENT_REFERENCE__VALUE){

			if(n.getEventType() == Notification.ADD) {

				if(ref.getEReference() != null) {
					// set the type of the reference as default value for the eClass reference
					((pamtram.metamodel.Class<?,?,?>) n.getNewValue()).
					setEClass(ref.getEReference().getEReferenceType());
				}
			}
		} 
	}

	// A Class has issued a notification.
	private void handleClassNotification(Notification n) {

		if(n.getEventType() == Notification.ADD) {

			if (n.getFeature() == MetamodelPackage.Literals.CLASS__REFERENCES){
				if(n.getNewValue() instanceof ContainmentReference) {
					// the notifying class
					pamtram.metamodel.Class<?,?,?> c = (Class<?,?,?>) n.getNotifier();

					// the created containment reference
					ContainmentReference<?,?,?> ref = (ContainmentReference<?,?,?>) n.getNewValue();

					if(c.getEClass() != null && ! c.getEClass().getEAllContainments().isEmpty()) {
						// set the first containment reference type of the class as default value for 
						// the eReference reference
						ref.setEReference(c.getEClass().getEAllContainments().get(0));
					}
				}
			}
		}
	}

	/**
	 * Set a (derived) string-based feature of an element based on another (original) feature that has changed.
	 * 
	 * The new value of the feature is composed of a prepended string, the new value of the original feature that
	 * is represented in the notification and an appended string.
	 * 
	 * The feature is only set, if the existing value of the feature is either 'null', empty, or matches the value
	 * that would have been set if this method would be called with a notification for the old value of the
	 * original feature.
	 * 
	 * @param object the element for which the feature shall be set
	 * @param derivedFeature the feature to set
	 * @param n the notification that shall be used to calculate the new value
	 * @param prependString a string that shall be prepended to the new value
	 * @param appendString a string that shall be appended to the new value
	 */
	private void setFeatureDerived(EObject object, EStructuralFeature derivedFeature, Notification n, String prependString, String appendString) {

		//			EStructuralFeature derivedFeature = object.eClass().getEStructuralFeature(derivedFeatureId);

		// The derived feature must be of type EString...
		if(derivedFeature == null || !(derivedFeature.getEType().getName().equals("EString"))) {
			throw new RuntimeException("'derivedFeature' is not of type 'EString'...");
		}

		EStructuralFeature originalFeature = (EStructuralFeature) n.getFeature();

		// The original feature must either be of type EString or NamedElement...
		if(!(originalFeature.getEType().getName().equals("EString") || 
				PamtramPackage.eINSTANCE.getNamedElement().isSuperTypeOf((EClass) originalFeature.getEType()) ||
				EcorePackage.eINSTANCE.getENamedElement().isSuperTypeOf((EClass) originalFeature.getEType()))) {
			throw new RuntimeException("'originalFeature' is neither of type 'EString' nor of type 'NamedElement' or 'ENamedElement'...");
		}

		String currentDerivedFeatureValue = (String) object.eGet(derivedFeature);

		Object oldOriginalFeatureValue, newOriginalFeatureValue;
		// determine the old value of the original feature based on its type
		if((oldOriginalFeatureValue = n.getOldValue()) != null) {
			if(oldOriginalFeatureValue instanceof NamedElement) {
				oldOriginalFeatureValue = ((NamedElement) oldOriginalFeatureValue).getName();
			} else if(oldOriginalFeatureValue instanceof ENamedElement) {
				oldOriginalFeatureValue = ((ENamedElement) oldOriginalFeatureValue).getName();
			}
		} else {
			oldOriginalFeatureValue = "";
		}
		// determine the new value of the original feature based on its type
		if((newOriginalFeatureValue = n.getNewValue()) != null) {
			if(newOriginalFeatureValue instanceof NamedElement) {
				newOriginalFeatureValue = ((NamedElement) newOriginalFeatureValue).getName();
			} else if(newOriginalFeatureValue instanceof ENamedElement) {
				newOriginalFeatureValue = ((ENamedElement) newOriginalFeatureValue).getName();
			}
		} else {
			newOriginalFeatureValue = "";
		}

		// if the current value of the derived feature is empty or matches the old value
		// of the original feature, set it to the new value of the original feature
		if(isEmptyOrValue(currentDerivedFeatureValue, prependString + (String) oldOriginalFeatureValue + appendString)) {
			object.eSet(derivedFeature, prependString + newOriginalFeatureValue + appendString);
		}
	}

	/**
	 * Convenience method to set a string-based feature of an element based on another feature that has changed. 
	 * Equal to calling 'setFeatureDerived(object, derivedFeatureId, n, "", "")'.
	 * 
	 * @param object
	 * @param derivedFeature
	 * @param n
	 */
	@SuppressWarnings("unused")
	private void setFeatureDerived(EObject object, EStructuralFeature derivedFeature, Notification n) {
		setFeatureDerived(object, derivedFeature, n, "", "");
	}

	/**
	 * Convenience method to set the name of a named element based on another feature that has changed. 
	 * Equal to calling 'setFeatureDerived(object, PamtramPackage.NAMED_ELEMENT__NAME, n, "", "")'.
	 * 
	 * @param object the element for which the feature shall be set
	 * @param n the notification that shall be used to calculate the new value
	 */
	private void setNameDerived(EObject object, Notification n) {
		setFeatureDerived(object, PamtramPackage.Literals.NAMED_ELEMENT__NAME, n, "", "");
	}

	/**
	 * Convenience method to set the name of a named element based on another feature that has changed. 
	 * Equal to calling 'setFeatureDerived(object, PamtramPackage.NAMED_ELEMENT__NAME, 
	 * n, preprendString, appendString)'.
	 * 
	 * @param object the element for which the feature shall be set
	 * @param n the notification that shall be used to calculate the new value
	 * @param prependString a string that shall be prepended to the new value
	 * @param appendString a string that shall be appended to the new value
	 */
	private void setNameDerived(EObject object, Notification n, String prependString, String appendString) {
		setFeatureDerived(object, PamtramPackage.Literals.NAMED_ELEMENT__NAME, n, prependString, appendString);
	}

	/**
	 * Returns true, if 'stringToTest' is either 'null', empty or matches the
	 * given value.
	 * 
	 * @param stringToTest the string that shall be checked
	 * @param value the string that 'stringToTest' shall be checked against;
	 * if 'value' is 'null', no check is performed
	 * 
	 * @return true if 'stringToTest' is 'null', empty or matches 'value'; false otherwise
	 */
	private boolean isEmptyOrValue(String stringToTest, String value) {
		return (stringToTest == null || stringToTest.isEmpty() || (value != null && stringToTest.equals(value)));
	}
}
