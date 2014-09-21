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
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingInstanceSelector;
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
        	handleReferenceNotification(n);
        } else if(notifier instanceof pamtram.metamodel.Class) {
        	handleClassNotification(n);
        } else if(notifier instanceof Attribute) {
        	handleAttributeNotification(n);
        } else if(notifier instanceof AttributeValueConstraint) {
        	handleAttributeValueConstraintNotification(n);
        } else if(notifier instanceof Mapping) {
        	handleMappingNotification(n);
        } else if(notifier instanceof MappingHintGroupType) {
        	handleMappingHintGroupTypeNotification(n);
        } else if(notifier instanceof AttributeMapping) {
        	handleAttributeMappingNotification(n);
        } else if(notifier instanceof AttributeMappingSourceElementType) {
        	handleAttributeMappingSourceElementTypeNotification(n);
        } else if(notifier instanceof AttributeValueModifier) {
        	handleAttributeValueModifierNotification(n);
        } else if(notifier instanceof GlobalAttribute) {
        	handleGlobalAttributeNotification(n);
        } else if(notifier instanceof MappingInstanceSelector) {
        	handleMappingInstanceSelectorNotification(n);
        }
	}

	// A ContainmentReference has issued a notification.
	private void handleReferenceNotification(Notification n) {
		
		// the notifying reference
		Reference ref = (Reference) n.getNotifier();
		
	    if (n.getFeature() == MetamodelPackage.Literals.SOURCE_SECTION_CONTAINMENT_REFERENCE__VALUE ||
	    		n.getFeature() == MetamodelPackage.Literals.TARGET_SECTION_CONTAINMENT_REFERENCE__VALUE ||
	    		n.getFeature() == MetamodelPackage.Literals.META_MODEL_SECTION_REFERENCE__VALUE ||
	    		n.getFeature() == MetamodelPackage.Literals.TARGET_SECTION_NON_CONTAINMENT_REFERENCE__VALUE){
	    	
			if(n.getEventType() == Notification.ADD) {
				
				if(ref.getEReference() != null) {
					// set the type of the reference as default value for the eClass reference
					((pamtram.metamodel.Class) n.getNewValue()).
							setEClass(ref.getEReference().getEReferenceType());
				}
			}
	    } else if (n.getFeature() == MetamodelPackage.Literals.REFERENCE__EREFERENCE) {
	    	// if the name of the reference has not been changed by the user, set it based on its eReference
	    	setNameDerived(ref, n);
	    }
	}
	
	// A Class has issued a notification.
	private void handleClassNotification(Notification n) {
		
		if(n.getEventType() == Notification.ADD) {
		
		    if (n.getFeature() == MetamodelPackage.Literals.SOURCE_SECTION_CLASS__REFERENCES ||
		    		n.getFeature() == MetamodelPackage.Literals.TARGET_SECTION_CLASS__REFERENCES){
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
			
		    if (n.getFeature() == MetamodelPackage.Literals.CLASS__ECLASS) {
		    	setNameDerived((pamtram.metamodel.Class) n.getNotifier(), n);
		    }
		}
	}
	
	// An Attribute has issued a notification.
	private void handleAttributeNotification(Notification n) {
		
		if(n.getEventType() == Notification.SET) {
		
			if (n.getFeature() == MetamodelPackage.Literals.SOURCE_SECTION_ATTRIBUTE__ATTRIBUTE ||
					n.getFeature() == MetamodelPackage.Literals.ACTUAL_ATTRIBUTE__ATTRIBUTE) {
				setNameDerived((Attribute) n.getNotifier(), n);
		    }
		}
	}
	
	// An Attribute Value Constraint has issued a notification.
	private void handleAttributeValueConstraintNotification(Notification n) {
	
		if(n.getEventType() == Notification.SET) {
			
			if(n.getFeature() == MetamodelPackage.Literals.ATTRIBUTE_VALUE_CONSTRAINT__VALUE) {
				setNameDerived((AttributeValueConstraint) n.getNotifier(), n);
			}
		}
	}
	
	// A Mapping has issued a notification.
	private void handleMappingNotification(Notification n) {
		
		if(n.getEventType() == Notification.SET) {
			
			if(n.getFeature() == MappingPackage.Literals.MAPPING_TYPE__SOURCE_MM_SECTION) {
				setNameDerived((Mapping) n.getNotifier(), n, "", "Mapping");
			}
		}
	}
	
	// A Mapping Hint Group or an Exported Mapping Hint Group has issued a notification.
	private void handleMappingHintGroupTypeNotification(Notification n) {
		
		if(n.getEventType() == Notification.SET) {
			
			if(n.getFeature() == MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__TARGET_MM_SECTION) {
				setNameDerived((MappingHintGroupType) n.getNotifier(), n);
			}
		}
	}
	
	// An Attribute Mapping has issued a notification.
	private void handleAttributeMappingNotification(Notification n) {
		
		if(n.getEventType() == Notification.SET) {
			
			if(n.getFeature() == MappingPackage.Literals.ATTRIBUTE_MAPPING__TARGET) {
				setNameDerived((AttributeMapping) n.getNotifier(), n, "", "Mapping");
			}
		}
	}
	
	// An Attribute Mapping Source Element Type has issued a notification.
	private void handleAttributeMappingSourceElementTypeNotification(
			Notification n) {
		
		if(n.getEventType() == Notification.SET) {
			
			if(n.getFeature() == MappingPackage.Literals.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__SOURCE) {
				setNameDerived((AttributeMappingSourceElementType) n.getNotifier(), n);
			}
		}
	}
	
	// An Attribute Value Modifier has issued a notification.
	private void handleAttributeValueModifierNotification(Notification n) {
	
		// the notifying attribute value modifier
		AttributeValueModifier mod = (AttributeValueModifier) n.getNotifier();
		
		// the parent attribute value modifier set
		AttributeValueModifierSet set = (AttributeValueModifierSet) mod.eContainer();
		
		if(n.getEventType() == Notification.SET) {
			
			if(mod instanceof SubstringReplacer) {
				SubstringReplacer rep = (SubstringReplacer) mod;
				if(n.getFeature() == MappingPackage.Literals.SUBSTRING_REPLACER__REGEX) {
					String appendString = "_to_" + (rep.getReplacement() != null ? rep.getReplacement() : "");
					setNameDerived(mod, n, "", appendString);
					if(set.getModifier().size() == 1) {
						setNameDerived(set, n, "replace \"", "\"");
					}
				} else if(n.getFeature() == MappingPackage.Literals.SUBSTRING_REPLACER__REPLACEMENT) {
					String preprendString = (rep.getRegex() != null ? rep.getRegex() : "") + "_to_";
					setNameDerived(rep, n, preprendString, "");
				}
			} else if(mod instanceof StringPrepender && n.getFeature() == MappingPackage.Literals.STRING_PREPENDER__STRING) {
				setNameDerived(mod, n);
				if(set.getModifier().size() == 1) {
					setNameDerived(set, n, "prepend \"", "\"");
				}
			} else if(mod instanceof StringAppender && n.getFeature() == MappingPackage.Literals.STRING_APPENDER__STRING) {
				setNameDerived(mod, n);
				if(set.getModifier().size() == 1) {
					setNameDerived(set, n, "append \"", "\"");
				}
			}
		}
	
	}
	
	// A Global Attribute has issued a notification.
	private void handleGlobalAttributeNotification(Notification n) {
	
		if(n.getEventType() == Notification.SET) {
	
			if(n.getFeature() == MappingPackage.Literals.GLOBAL_ATTRIBUTE__SOURCE) {
				setNameDerived((GlobalAttribute) n.getNotifier(), n);
			}
		}
	}
	
	// A Mapping Instance Selector has issued a notification.
	private void handleMappingInstanceSelectorNotification(Notification n) {

		if(n.getEventType() == Notification.SET) {
			
			if(n.getFeature() == MappingPackage.Literals.MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE) {
				setNameDerived((MappingInstanceSelector) n.getNotifier(), n);
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
	
//		EStructuralFeature derivedFeature = object.eClass().getEStructuralFeature(derivedFeatureId);
		
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
