/**
 */
package pamtram.structure.generic;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This represents one element (as an instance of an EClass) of an element structure.
 * <br />
 * In order to allow for the description of complex element structures, Classes can be equipped with Attributes and References (which itself may reference/contain other Classes).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.generic.Class#getEClass <em>EClass</em>}</li>
 *   <li>{@link pamtram.structure.generic.Class#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link pamtram.structure.generic.Class#getReferences <em>References</em>}</li>
 *   <li>{@link pamtram.structure.generic.Class#getContainer <em>Container</em>}</li>
 *   <li>{@link pamtram.structure.generic.Class#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link pamtram.structure.generic.Class#getAllContainer <em>All Container</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.generic.GenericPackage#getClass_()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='eClassMatchesParentEReference variableCardinalityIsValid containerIsValid'"
 * @generated
 */
public interface Class<S extends Section<S, C, R, A>, C extends Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends MetaModelElement<S, C, R, A> {
	/**
	 * Returns the value of the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EClass</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The metamodel element (EClass) that this Class represents.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>EClass</em>' reference.
	 * @see #setEClass(EClass)
	 * @see pamtram.structure.generic.GenericPackage#getClass_EClass()
	 * @model required="true"
	 * @generated
	 */
	EClass getEClass();

	/**
	 * Sets the value of the '{@link pamtram.structure.generic.Class#getEClass <em>EClass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EClass</em>' reference.
	 * @see #getEClass()
	 * @generated
	 */
	void setEClass(EClass value);

	/**
	 * Returns the value of the '<em><b>Cardinality</b></em>' attribute.
	 * The default value is <code>"ONE"</code>.
	 * The literals are from the enumeration {@link pamtram.structure.generic.CardinalityType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cardinality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This can be used to specify a cardinality constraint for this element.
	 * <br />
	 * For example, setting this to 'ONE' means that exactly one element must be present to be matched (for SourceSections) resp. will be created during the execution of one mapping (for TargetSections).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cardinality</em>' attribute.
	 * @see pamtram.structure.generic.CardinalityType
	 * @see #setCardinality(CardinalityType)
	 * @see pamtram.structure.generic.GenericPackage#getClass_Cardinality()
	 * @model default="ONE" required="true"
	 * @generated
	 */
	CardinalityType getCardinality();

	/**
	 * Sets the value of the '{@link pamtram.structure.generic.Class#getCardinality <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cardinality</em>' attribute.
	 * @see pamtram.structure.generic.CardinalityType
	 * @see #getCardinality()
	 * @generated
	 */
	void setCardinality(CardinalityType value);

	/**
	 * Returns the value of the '<em><b>References</b></em>' containment reference list.
	 * It is bidirectional and its opposite is '{@link pamtram.structure.generic.Reference#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of References based on which further elements of the element structure a specified.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>References</em>' containment reference list.
	 * @see pamtram.structure.generic.GenericPackage#getClass_References()
	 * @see pamtram.structure.generic.Reference#getOwningClass
	 * @model opposite="owningClass" containment="true"
	 * @generated
	 */
	EList<R> getReferences();

	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This can be used to specify additional constraints on the containment structure of the current element structure.
	 * <br />
	 * For SourceSections: By setting the 'container' reference, SourceSections will only be matched if the specified container Class can also be matched in the source model.
	 * <br />
	 * For TargetSections: Created target structures will automatically connected to (contained by) an instance of the specified container Class.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #setContainer(Class)
	 * @see pamtram.structure.generic.GenericPackage#getClass_Container()
	 * @model
	 * @generated
	 */
	C getContainer();

	/**
	 * Sets the value of the '{@link pamtram.structure.generic.Class#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(C value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * It is bidirectional and its opposite is '{@link pamtram.structure.generic.Attribute#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of Attribute further describing the current element.
	 * <br />
	 * Specified attributes can e.g. be equipped with additional constraints (for SourceSections) or can be set via an AttributeMapping (for TargetSections).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see pamtram.structure.generic.GenericPackage#getClass_Attributes()
	 * @see pamtram.structure.generic.Attribute#getOwningClass
	 * @model opposite="owningClass" containment="true"
	 * @generated
	 */
	EList<A> getAttributes();

	/**
	 * Returns the value of the '<em><b>All Container</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Container</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Container</em>' reference list.
	 * @see pamtram.structure.generic.GenericPackage#getClass_AllContainer()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%java.util.List%><Object> ret = new <%java.util.ArrayList%><>();\r\nif(this.getContainer() != null) {\r\n\tret.add(this.getContainer());\r\n\tret.addAll(this.getContainer().getAllContainer());\r\n\t\r\n\tif(this.getContainer() instanceof <%pamtram.structure.generic.Section%><?, ?, ?, ?>) {\t\t\t\t\r\n\t\tret.addAll(((Section<?, ?, ?, ?>) this.getContainer()).getAllExtend());\r\n\t\tret.addAll(((Section<?, ?, ?, ?>) this.getContainer()).getAllExtend().stream().flatMap(s -> s.getAllContainer().stream()).collect(<%java.util.stream.Collectors%>.toList()));\r\n\t}\r\n}\r\n\r\nret = ret.stream().distinct().collect(Collectors.toList());\r\n\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.structure.generic.GenericPackage%>.Literals.CLASS__ALL_CONTAINER,\r\n\t\tret.size(), ret.toArray());'"
	 * @generated
	 */
	EList<C> getAllContainer();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" containedClassRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='C container = containedClass.getContainer();\r\n\t\t\r\n// this means that we have reached the top level container for the \'containedClass\'\r\nif(container == null) {\r\n\treturn false;\r\n// this is the container\r\n} else if(this.equals(container)) {\r\n\treturn true;\r\n// one of the extended sections is the container\r\n} else if(container instanceof Section && ((Section) container).getExtend().contains(this)) {\r\n\treturn true;\r\n// this was not the container, so iterate up in the containment hierarchy\r\n} else {\r\n\treturn isContainerFor(container);\r\n}'"
	 * @generated
	 */
	boolean isContainerFor(C containedClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" containerClassRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<C> containedClasses = new BasicEList<>();\r\n\r\n// collect all classes that are referenced by containment references\r\nBasicEList<R> refs = new BasicEList<>(containerClass.getReferences());\r\nif(containerClass instanceof Section) {\r\n\tEList<Section> sections = ((Section) containerClass).getExtend(); \r\n\tfor (Section s : sections) {\r\n\t\trefs.addAll(s.getReferences());\r\n\t}\r\n}\r\n\r\nfor (R ref : containerClass.getReferences()) {\r\n\tif(!(ref instanceof ActualReference<?, ?, ?, ?>) || !(((ActualReference<?, ?, ?, ?>) ref).getEReference().isContainment())) {\r\n\t\tcontinue;\r\n\t}\r\n\tif(ref instanceof CompositeReference<?,?,?,?>){\r\n\t\tcontainedClasses.addAll(((CompositeReference<S,C,R,A>) ref).getValue());\r\n\t} else if(ref instanceof CrossReference) {\r\n\t\tcontainedClasses.addAll((Collection<? extends C>) ((CrossReference) ref).getValue());\r\n\t}\r\n}\r\n\t\r\n// recursively iterate over all contained classes\r\nboolean found = false;\r\nfor (C containedClass : containedClasses) {\r\n\tif(containedClass.equals(this) || isContainedIn(containedClass)) {\r\n\t\tfound = true;\r\n\t\tbreak;\r\n\t}\r\n}\r\n\r\nreturn found;'"
	 * @generated
	 */
	boolean isContainedIn(C containerClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this.eContainer() instanceof CompositeReference<?,?,?,?>) {\r\n\treturn (CompositeReference<S,C,R,A>) this.eContainer();\r\n} else {\r\n\treturn null;\r\n}'"
	 * @generated
	 */
	CompositeReference<S, C, R, A> getOwningContainmentReference();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" referencingClassRequired="true" referencedClassesMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if(referencedClasses == null) {\r\n\treferencedClasses = new BasicEList<>();\r\n}\r\nBasicEList<C> classes = new BasicEList<>();\r\n\r\n// collect all classes that are referenced\r\nfor (R ref : referencingClass.getReferences()) {\r\n\r\n\tif(ref instanceof ContainmentReference<?,?,?,?>){\r\n\t\tclasses.addAll(((ContainmentReference<S,C,R,A>) ref).getValue());\r\n\t} else if(ref instanceof MetaModelSectionReference) {\r\n\t\tclasses.addAll((Collection<? extends C>) ((MetaModelSectionReference) ref).getValue());\r\n\t} else if(ref instanceof NonContainmentReference){\r\n\t\tclasses.addAll(((NonContainmentReference<S,C,R,A>) ref).getValue());\r\n\t}\r\n}\r\n\r\n// recursively iterate over all referenced classes\r\nfor (C clazz : classes) {\r\n\tif(clazz.equals(this) || isReferencedBy(clazz, referencedClasses)) {\r\n\t\treturn true;\r\n\t} else {\r\n\t\tif(!referencedClasses.contains(clazz)) {\r\n\t\t\treferencedClasses.add(clazz);\r\n\t\t}\r\n\t}\r\n}\r\n\r\nreturn false;'"
	 * @generated
	 */
	boolean isReferencedBy(C referencingClass, EList<C> referencedClasses);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif(this == this.getContainingSection() || this.getEClass() == null || !(this.eContainer() instanceof ActualReference<?, ?, ?, ?>)) {\r\n\treturn true;\r\n}\r\n\r\n<%pamtram.structure.generic.ActualReference%><?, ?, ?, ?> parentReference = (ActualReference<?, ?, ?, ?>) this.eContainer();\r\n\r\nif(parentReference.getEReference() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = parentReference.getEReference().getEReferenceType().isSuperTypeOf(this.getEClass());\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The eClass \'\" + this.eClass().getName() + \"\' is not allowed by the containing reference!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.structure.generic.util.GenericValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tGenericValidator.CLASS__VALIDATE_ECLASS_MATCHES_PARENT_EREFERENCE,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.generic.GenericPackage%>.Literals.CLASS__ECLASS }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateEClassMatchesParentEReference(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif(this == this.getContainingSection() || this.getEClass() == null || !(this.eContainer() instanceof ActualReference<?, ?, ?, ?>)) {\r\n\treturn true;\r\n}\r\n\r\n<%pamtram.structure.generic.ActualReference%><?, ?, ?, ?> parentReference = (ActualReference<?, ?, ?, ?>) this.eContainer();\r\n\r\nif(parentReference.getEReference() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = !(this.cardinality != <%pamtram.structure.generic.CardinalityType%>.ONE && parentReference.getEReference().getUpperBound() == 1);\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The cardinality of a Class must be specified as \'CardinalityType::ONE\' when the upper bound of the containing Reference is \'1\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.structure.generic.util.GenericValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tGenericValidator.CLASS__VALIDATE_CARDINALITY_IS_VALID,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.generic.GenericPackage%>.Literals.CLASS__CARDINALITY }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateCardinalityIsValid(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this instanceof <%pamtram.structure.generic.Section%><?, ?, ?, ?> || this.getContainer() == null ? true : this.getContainer().equals(this.eContainer().eContainer());\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The \'container\' refrence must point to the containing Class!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.structure.generic.util.GenericValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tGenericValidator.CLASS__VALIDATE_CONTAINER_IS_VALID,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.generic.GenericPackage%>.Literals.CLASS__CONTAINER }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateContainerIsValid(DiagnosticChain diagnostics, Map<?, ?> context);

} // Class
