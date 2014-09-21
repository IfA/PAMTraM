package pamtram.presentation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EContentAdapter;

import pamtram.NamedElement;
import pamtram.PamtramPackage;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceElementType;
import pamtram.mapping.AttributeValueModifier;
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.ComplexAttributeMappingSourceElement;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.StringAppender;
import pamtram.mapping.StringPrepender;
import pamtram.mapping.SubstringReplacer;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.Class;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.Reference;

/**
 * A content adapter that listens for changes in a pamtram instance
 * and tries to automatically determine attribute values or reference
 * targets based on the changed object.
 * 
 * @author mfreund
 */
public class PamtramContentAdapter extends EContentAdapter {

	@Override
	public void notifyChanged(Notification n) {
		super.notifyChanged(n);

		if(n.getEventType() == Notification.RESOLVE) {
			return;
		}
		
		// find out the type of the notifier
        Object notifier = n.getNotifier();
        
        if(notifier instanceof Reference) {
        	handleReferenceNotification(n, n.getFeatureID(Reference.class));
        } else if(notifier instanceof pamtram.metamodel.Class) {
        	handleClassNotification(n, n.getFeatureID(pamtram.metamodel.Class.class));
        } else if(notifier instanceof Attribute) {
        	handleAttributeNotification(n, n.getFeatureID(Attribute.class));
        } else if(notifier instanceof AttributeValueConstraint) {
        	handleAttributeValueConstraintNotification(n, n.getFeatureID(AttributeValueConstraint.class));
        } else if(notifier instanceof Mapping) {
        	handleMappingNotification(n, n.getFeatureID(Mapping.class));
        } else if(notifier instanceof MappingHintGroupType) {
        	handleMappingHintGroupTypeNotification(n, n.getFeatureID(MappingHintGroupType.class));
        } else if(notifier instanceof AttributeMapping) {
        	handleAttributeMappingNotification(n, n.getFeatureID(AttributeMapping.class));
        } else if(notifier instanceof AttributeMappingSourceElementType) {
        	handleAttributeMappingSourceElementTypeNotification(n, n.getFeatureID(ComplexAttributeMappingSourceElement.class));
        } else if(notifier instanceof AttributeValueModifier) {
        	handleAttributeValueModifierNotification(n, n.getFeatureID(AttributeValueModifier.class));
        } else if(notifier instanceof GlobalAttribute) {
        	handleGlobalAttributeNotification(n, n.getFeatureID(GlobalAttribute.class));
        }
	}
	
	// A ContainmentReference has issued a notification.
	private void handleReferenceNotification(Notification n, int featureID) {
		
		// the notifying reference
		Reference ref = (Reference) n.getNotifier();
		
	    if (featureID == MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE__VALUE ||
	    		featureID == MetamodelPackage.TARGET_SECTION_CONTAINMENT_REFERENCE__VALUE ||
	    		featureID == MetamodelPackage.META_MODEL_SECTION_REFERENCE__VALUE ||
	    		featureID == MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE__VALUE){
	    	
			if(n.getEventType() == Notification.ADD) {
				
				if(ref.getEReference() != null) {
					// set the type of the reference as default value for the eClass reference
					((pamtram.metamodel.Class) n.getNewValue()).
							setEClass(ref.getEReference().getEReferenceType());
				}
			}
	    } else if (featureID == MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE__EREFERENCE ||
	    		featureID == MetamodelPackage.TARGET_SECTION_CONTAINMENT_REFERENCE__EREFERENCE ||
	    		featureID == MetamodelPackage.META_MODEL_SECTION_REFERENCE__EREFERENCE ||
	    		featureID == MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE__EREFERENCE) {
	    	// if the name of the reference has not been changed by the user, set it based on its eReference
	    	setNameDerived(ref, n);
	    }
	}
	
	// A Class has issued a notification.
	private void handleClassNotification(Notification n, int featureID) {
		
		if(n.getEventType() == Notification.ADD) {
		
		    if (featureID == MetamodelPackage.SOURCE_SECTION_CLASS__REFERENCES ||
		    		featureID == MetamodelPackage.TARGET_SECTION_CLASS__REFERENCES){
	    		if(n.getNewValue() instanceof ContainmentReference) {
	    			// the notifying class
	    			pamtram.metamodel.Class c = (Class) n.getNotifier();
	    			
	    			// the created containment reference
	    			ContainmentReference ref = (ContainmentReference) n.getNewValue();
	    			
	    			if(! c.getEClass().getEAllContainments().isEmpty()) {
	    				// set the first containment reference type of the class as default value for 
	    				// the eReference reference
	    				ref.setEReference(c.getEClass().getEAllContainments().get(0));
	    			}
	    		}
	    	}
		} else if(n.getEventType() == Notification.SET) {
			
		    if (featureID == pamtram.metamodel.MetamodelPackage.CLASS__ECLASS) {
		    	setNameDerived((pamtram.metamodel.Class) n.getNotifier(), n);
		    }
		}
	}
	
	// An Attribute has issued a notification.
	private void handleAttributeNotification(Notification n, int featureID) {
		
		if(n.getEventType() == Notification.SET) {
		
			if (featureID == MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__ATTRIBUTE ||
					featureID == MetamodelPackage.ACTUAL_ATTRIBUTE__ATTRIBUTE) {
				setNameDerived((Attribute) n.getNotifier(), n);
		    }
		}
	}
	
	// An Attribute Value Constraint has issued a notification.
	private void handleAttributeValueConstraintNotification(Notification n, int featureID) {
	
		if(n.getEventType() == Notification.SET) {
			
			if(featureID == MetamodelPackage.ATTRIBUTE_VALUE_CONSTRAINT__VALUE) {
				setNameDerived((AttributeValueConstraint) n.getNotifier(), n);
			}
		}
	}
	
	// A Mapping has issued a notification.
	private void handleMappingNotification(Notification n, int featureID) {
		
		if(n.getEventType() == Notification.SET) {
			
			if(featureID == MappingPackage.MAPPING__SOURCE_MM_SECTION) {
				setNameDerived((Mapping) n.getNotifier(), n, "", "Mapping");
			}
		}
	}
	
	// A Mapping Hint Group or an Exported Mapping Hint Group has issued a notification.
	private void handleMappingHintGroupTypeNotification(Notification n, int featureID) {
		
		if(n.getEventType() == Notification.SET) {
			
			if(featureID == MappingPackage.MAPPING_HINT_GROUP_TYPE__TARGET_MM_SECTION) {
				setNameDerived((MappingHintGroupType) n.getNotifier(), n);
			}
		}
	}
	
	// An Attribute Mapping has issued a notification.
	private void handleAttributeMappingNotification(Notification n, int featureID) {
		
		if(n.getEventType() == Notification.SET) {
			
			if(featureID == MappingPackage.ATTRIBUTE_MAPPING__TARGET) {
				setNameDerived((AttributeMapping) n.getNotifier(), n, "", "Mapping");
			}
		}
	}
	
	// An Attribute Mapping Source Element Type has issued a notification.
	private void handleAttributeMappingSourceElementTypeNotification(
			Notification n, int featureID) {
		
		if(n.getEventType() == Notification.SET) {
			
			if(featureID == MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__SOURCE) {
				setNameDerived((AttributeMappingSourceElementType) n.getNotifier(), n);
			}
		}
	}
	
	// An Attribute Value Modifier has issued a notification.
	private void handleAttributeValueModifierNotification(Notification n, int featureID) {
	
		// the notifying attribute value modifier
		AttributeValueModifier mod = (AttributeValueModifier) n.getNotifier();
		
		// the parent attribute value modifier set
		AttributeValueModifierSet set = (AttributeValueModifierSet) mod.eContainer();
		
		if(n.getEventType() == Notification.SET) {
			
			if(mod instanceof SubstringReplacer) {
				SubstringReplacer rep = (SubstringReplacer) mod;
				if(featureID == MappingPackage.SUBSTRING_REPLACER__REGEX) {
					String appendString = "_to_" + (rep.getReplacement() != null ? rep.getReplacement() : "");
					setNameDerived(mod, n, "", appendString);
					if(set.getModifier().size() == 1) {
						setNameDerived(set, n, "replace \"", "\"");
					}
				} else if(featureID == MappingPackage.SUBSTRING_REPLACER__REPLACEMENT) {
					String preprendString = (rep.getRegex() != null ? rep.getRegex() : "") + "_to_";
					setNameDerived(rep, n, preprendString, "");
				}
			} else if(mod instanceof StringPrepender && featureID == MappingPackage.STRING_PREPENDER__STRING) {
				setNameDerived(mod, n);
				if(set.getModifier().size() == 1) {
					setNameDerived(set, n, "prepend \"", "\"");
				}
			} else if(mod instanceof StringAppender && featureID == MappingPackage.STRING_APPENDER__STRING) {
				setNameDerived(mod, n);
				if(set.getModifier().size() == 1) {
					setNameDerived(set, n, "append \"", "\"");
				}
			}
		}
	
	}
	
	// A Global Attribute has issued a notification.
	private void handleGlobalAttributeNotification(Notification n, int featureID) {
	
		if(n.getEventType() == Notification.SET) {
	
			if(featureID == MappingPackage.GLOBAL_ATTRIBUTE__SOURCE) {
				setNameDerived((GlobalAttribute) n.getNotifier(), n);
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
	 * @param derivedFeatureId the id of the feature to set
	 * @param n the notification that shall be used to calculate the new value
	 * @param prependString a string that shall be prepended to the new value
	 * @param appendString a string that shall be appended to the new value
	 */
	private void setFeatureDerived(EObject object, int derivedFeatureId, Notification n, String prependString, String appendString) {
	
		EStructuralFeature derivedFeature = object.eClass().getEStructuralFeature(derivedFeatureId);
		
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
	 * @param derivedFeatureId
	 * @param n
	 */
	@SuppressWarnings("unused")
	private void setFeatureDerived(EObject object, int derivedFeatureId, Notification n) {
		setFeatureDerived(object, derivedFeatureId, n, "", "");
	}
	
	/**
	 * Convenience method to set the name of a named element based on another feature that has changed. 
	 * Equal to calling 'setFeatureDerived(object, PamtramPackage.NAMED_ELEMENT__NAME, n, "", "")'.
	 * 
	 * @param object the element for which the feature shall be set
	 * @param n the notification that shall be used to calculate the new value
	 */
	private void setNameDerived(EObject object, Notification n) {
		setFeatureDerived(object, PamtramPackage.NAMED_ELEMENT__NAME, n, "", "");
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
		setFeatureDerived(object, PamtramPackage.NAMED_ELEMENT__NAME, n, prependString, appendString);
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
