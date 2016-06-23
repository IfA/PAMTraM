/**
 */
package pamtram.metamodel;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.Class#getEClass <em>EClass</em>}</li>
 *   <li>{@link pamtram.metamodel.Class#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link pamtram.metamodel.Class#getReferences <em>References</em>}</li>
 *   <li>{@link pamtram.metamodel.Class#getContainer <em>Container</em>}</li>
 *   <li>{@link pamtram.metamodel.Class#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getClass_()
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
	 * @return the value of the '<em>EClass</em>' reference.
	 * @see #setEClass(EClass)
	 * @see pamtram.metamodel.MetamodelPackage#getClass_EClass()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!Class{S,C,R,A}!eClass'"
	 * @generated
	 */
	EClass getEClass();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.Class#getEClass <em>EClass</em>}' reference.
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
	 * The literals are from the enumeration {@link pamtram.metamodel.CardinalityType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cardinality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cardinality</em>' attribute.
	 * @see pamtram.metamodel.CardinalityType
	 * @see #setCardinality(CardinalityType)
	 * @see pamtram.metamodel.MetamodelPackage#getClass_Cardinality()
	 * @model default="ONE" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!Class{S,C,R,A}!cardinality'"
	 * @generated
	 */
	CardinalityType getCardinality();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.Class#getCardinality <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cardinality</em>' attribute.
	 * @see pamtram.metamodel.CardinalityType
	 * @see #getCardinality()
	 * @generated
	 */
	void setCardinality(CardinalityType value);

	/**
	 * Returns the value of the '<em><b>References</b></em>' containment reference list.
	 * It is bidirectional and its opposite is '{@link pamtram.metamodel.Reference#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getClass_References()
	 * @see pamtram.metamodel.Reference#getOwningClass
	 * @model opposite="owningClass" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!Class{S,C,R,A}!references'"
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
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #setContainer(Class)
	 * @see pamtram.metamodel.MetamodelPackage#getClass_Container()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!Class{S,C,R,A}!container'"
	 * @generated
	 */
	C getContainer();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.Class#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(C value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * It is bidirectional and its opposite is '{@link pamtram.metamodel.Attribute#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getClass_Attributes()
	 * @see pamtram.metamodel.Attribute#getOwningClass
	 * @model opposite="owningClass" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!Class{S,C,R,A}!attributes'"
	 * @generated
	 */
	EList<A> getAttributes();

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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<C> containedClasses = new BasicEList<>();\r\n\r\n// collect all classes that are referenced by containment references\r\nBasicEList<R> refs = new BasicEList<>(containerClass.getReferences());\r\nif(containerClass instanceof Section) {\r\n\tEList<Section> sections = ((Section) containerClass).getExtend(); \r\n\tfor (Section s : sections) {\r\n\t\trefs.addAll(s.getReferences());\r\n\t}\r\n}\r\n\r\nfor (R ref : containerClass.getReferences()) {\r\n\tif(!(ref.getEReference().isContainment())) {\r\n\t\tcontinue;\r\n\t}\r\n\tif(ref instanceof ContainmentReference<?,?,?,?>){\r\n\t\tcontainedClasses.addAll(((ContainmentReference<S,C,R,A>) ref).getValue());\r\n\t} else if(ref instanceof MetaModelSectionReference) {\r\n\t\tcontainedClasses.addAll((Collection<? extends C>) ((MetaModelSectionReference) ref).getValue());\r\n\t}\r\n}\r\n\t\r\n// recursively iterate over all contained classes\r\nboolean found = false;\r\nfor (C containedClass : containedClasses) {\r\n\tif(containedClass.equals(this) || isContainedIn(containedClass)) {\r\n\t\tfound = true;\r\n\t\tbreak;\r\n\t}\r\n}\r\n\r\nreturn found;'"
	 * @generated
	 */
	boolean isContainedIn(C containerClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this.eContainer() instanceof ContainmentReference<?,?,?,?>) {\r\n\treturn (ContainmentReference<S,C,R,A>) this.eContainer();\r\n} else {\r\n\treturn null;\r\n}'"
	 * @generated
	 */
	ContainmentReference<S, C, R, A> getOwningContainmentReference();

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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv containerIsValid:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[1] = if\n *         self.oclIsKindOf(Section(S, C, R, A)) = true or self.container = null\n *       then true\n *       else self.container = self.oclContainer().oclContainer()\n *       endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'The \\\'container\\\' refrence must point to the containing Class!\'\n *         else null\n *         endif\n *       in\n *         \'Class::containerIsValid\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = executor.getIdResolver();\n/*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_Section, null);\n    final /*@NonInvalid\052/ boolean oclIsKindOf = <%org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation%>.INSTANCE.evaluate(executor, this, TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e).booleanValue();\n    /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_eq;\n    try {\n        final /*@Thrown\052/ <%java.lang.Object%> container = this.getContainer();\n        final /*@Thrown\052/ boolean eq = container == null;\n        CAUGHT_eq = eq;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_eq = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@Thrown\052/ <%java.lang.Boolean%> or = <%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%>.INSTANCE.evaluate(oclIsKindOf, CAUGHT_eq);\n    if (or == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null if condition\");\n    }\n    /*@Thrown\052/ boolean status;\n    if (or) {\n        status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    else {\n        final /*@Thrown\052/ <%java.lang.Object%> container_0 = this.getContainer();\n        final /*@NonInvalid\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, this);\n        final /*@Thrown\052/ <%java.lang.Object%> oclContainer_0 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, oclContainer);\n        final /*@Thrown\052/ boolean eq_0 = (container_0 != null) ? container_0.equals(oclContainer_0) : (oclContainer_0 == null);\n        status = eq_0;\n    }\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.metamodel.MetamodelTables%>.STR_The_32_39_container_39_32_refrence_32_must_32_point_32_to_32_the_32_containing_32_Class_33;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.metamodel.MetamodelTables%>.STR_Class_c_c_containerIsValid, this, null, diagnostics, context, message_0, <%pamtram.metamodel.MetamodelTables%>.INT_4, CAUGHT_status, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean containerIsValid(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv cardinalityIsValid:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[?] = if self =\n *         self.getContainingSection() or\n *         self.eClass.oclType() = OclVoid\n *       then true\n *       else\n *         let\n *           parentEReference : ecore::EReference[1] = self.oclContainer()\n *           .oclAsType(Reference(S, C, R, A)).eReference\n *         in\n *           if parentEReference.oclType() = OclVoid\n *           then true\n *           else\n *             not (self.cardinality <> CardinalityType::ONE and\n *               self.oclContainer()\n *               .oclAsType(Reference(S, C, R, A))\n *               .eReference.oclAsType(ecore::EReference).upperBound = 1\n *             )\n *           endif\n *       endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'The cardinality of a Class must be specified as \\\'CardinalityType::ONE\\\' when the upper bound of the containing Reference is \\\'1\\\'!\'\n *         else null\n *         endif\n *       in\n *         \'Class::cardinalityIsValid\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = executor.getIdResolver();\n/*@Caught\052/ /*@Nullable\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_eq;\n    try {\n        final /*@Thrown\052/ <%java.lang.Object%> getContainingSection = ((<%pamtram.metamodel.MetaModelElement%>)this).getContainingSection();\n        final /*@Thrown\052/ boolean eq = this.equals(getContainingSection);\n        CAUGHT_eq = eq;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_eq = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_eq_0;\n    try {\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_0 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n        final /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> eClass = this.getEClass();\n        final /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType = (<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(executor, eClass);\n        final /*@Thrown\052/ boolean eq_0 = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();\n        CAUGHT_eq_0 = eq_0;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_eq_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@Thrown\052/ <%java.lang.Boolean%> or = <%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%>.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);\n    if (or == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null if condition\");\n    }\n    /*@Thrown\052/ <%java.lang.Boolean%> status;\n    if (or) {\n        status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    else {\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_Reference_o_S_44_C_44_R_44_A_e_0 = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_Reference, null);\n        final /*@NonInvalid\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, this);\n        final /*@Thrown\052/ <%pamtram.metamodel.Reference%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.Reference%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, oclContainer, TYP_pamtram_c_c_metamodel_c_c_Reference_o_S_44_C_44_R_44_A_e_0));\n        final /*@Thrown\052/ <%org.eclipse.emf.ecore.EReference%> parentEReference = oclAsType.getEReference();\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_1 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n        final /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType_0 = (<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(executor, parentEReference);\n        final /*@Thrown\052/ boolean eq_1 = oclType_0.getTypeId() == TYP_OclVoid_1.getTypeId();\n        /*@Thrown\052/ <%java.lang.Boolean%> symbol_0;\n        if (eq_1) {\n            symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n        }\n        else {\n            /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_ne;\n            try {\n                final /*@Thrown\052/ <%pamtram.metamodel.CardinalityType%> cardinality = this.getCardinality();\n                final /*@Thrown\052/ <%org.eclipse.ocl.pivot.ids.EnumerationLiteralId%> BOXED_cardinality = <%pamtram.metamodel.MetamodelTables%>.ENUMid_CardinalityType.getEnumerationLiteralId(<%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(cardinality.getName()));\n                final /*@Thrown\052/ boolean ne = BOXED_cardinality != <%pamtram.metamodel.MetamodelTables%>.ELITid_ONE;\n                CAUGHT_ne = ne;\n            }\n            catch (<%java.lang.Exception%> e) {\n                CAUGHT_ne = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n            }\n            /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_eq_2;\n            try {\n                final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_ecore_c_c_EReference_0 = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_EReference, null);\n                final /*@Thrown\052/ <%org.eclipse.emf.ecore.EReference%> eReference = oclAsType.getEReference();\n                final /*@Thrown\052/ <%org.eclipse.emf.ecore.EReference%> oclAsType_1 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.emf.ecore.EReference%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, eReference, TYP_ecore_c_c_EReference_0));\n                final /*@Thrown\052/ int upperBound = oclAsType_1.getUpperBound();\n                final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> BOXED_upperBound = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.integerValueOf(upperBound);\n                final /*@Thrown\052/ boolean eq_2 = <%pamtram.metamodel.MetamodelTables%>.INT_1.equals(BOXED_upperBound);\n                CAUGHT_eq_2 = eq_2;\n            }\n            catch (<%java.lang.Exception%> e) {\n                CAUGHT_eq_2 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n            }\n            final /*@Thrown\052/ <%java.lang.Boolean%> and = <%org.eclipse.ocl.pivot.library.logical.BooleanAndOperation%>.INSTANCE.evaluate(CAUGHT_ne, CAUGHT_eq_2);\n            final /*@Thrown\052/ <%java.lang.Boolean%> not = <%org.eclipse.ocl.pivot.library.logical.BooleanNotOperation%>.INSTANCE.evaluate(and);\n            symbol_0 = not;\n        }\n        status = symbol_0;\n    }\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne_0 = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne_0) {\n    message_0 = <%pamtram.metamodel.MetamodelTables%>.STR_The_32_cardinality_32_of_32_a_32_Class_32_must_32_be_32_specified_32_as_32_39_CardinalityType;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.metamodel.MetamodelTables%>.STR_Class_c_c_cardinalityIsValid, this, null, diagnostics, context, message_0, <%pamtram.metamodel.MetamodelTables%>.INT_4, CAUGHT_status, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean cardinalityIsValid(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv eClassMatchesParentEReference:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[?] = if self =\n *         self.getContainingSection() or\n *         self.eClass.oclType() = OclVoid\n *       then true\n *       else\n *         let\n *           parentEReference : ecore::EReference[1] = self.oclContainer()\n *           .oclAsType(Reference(S, C, R, A)).eReference\n *         in\n *           if parentEReference.oclType() = OclVoid\n *           then true\n *           else\n *             parentEReference.oclAsType(ecore::EReference)\n *             .eReferenceType.isSuperTypeOf(\n *               self.eClass.oclAsType(ecore::EClass))\n *           endif\n *       endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'The eClass \\\'\' + self.eClass.name + \'\\\' is not allowed by the containing reference!\'\n *         else null\n *         endif\n *       in\n *         \'Class::eClassMatchesParentEReference\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = executor.getIdResolver();\n/*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_eq;\n    try {\n        final /*@Thrown\052/ <%java.lang.Object%> getContainingSection = ((<%pamtram.metamodel.MetaModelElement%>)this).getContainingSection();\n        final /*@Thrown\052/ boolean eq = this.equals(getContainingSection);\n        CAUGHT_eq = eq;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_eq = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_eq_0;\n    try {\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n        final /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> eClass = this.getEClass();\n        final /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType = (<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(executor, eClass);\n        final /*@Thrown\052/ boolean eq_0 = oclType.getTypeId() == TYP_OclVoid.getTypeId();\n        CAUGHT_eq_0 = eq_0;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_eq_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@Thrown\052/ <%java.lang.Boolean%> or = <%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%>.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);\n    if (or == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null if condition\");\n    }\n    /*@Thrown\052/ boolean status;\n    if (or) {\n        status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    else {\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_Reference_o_S_44_C_44_R_44_A_e = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_Reference, null);\n        final /*@NonInvalid\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, this);\n        final /*@Thrown\052/ <%pamtram.metamodel.Reference%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.Reference%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, oclContainer, TYP_pamtram_c_c_metamodel_c_c_Reference_o_S_44_C_44_R_44_A_e));\n        final /*@Thrown\052/ <%org.eclipse.emf.ecore.EReference%> parentEReference = oclAsType.getEReference();\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_0 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n        final /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType_0 = (<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(executor, parentEReference);\n        final /*@Thrown\052/ boolean eq_1 = oclType_0.getTypeId() == TYP_OclVoid_0.getTypeId();\n        /*@Thrown\052/ boolean symbol_0;\n        if (eq_1) {\n            symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n        }\n        else {\n            final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_ecore_c_c_EClass = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_EClass, null);\n            final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_ecore_c_c_EReference = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_EReference, null);\n            final /*@Thrown\052/ <%org.eclipse.emf.ecore.EReference%> oclAsType_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.emf.ecore.EReference%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, parentEReference, TYP_ecore_c_c_EReference));\n            final /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> eReferenceType = oclAsType_0.getEReferenceType();\n            final /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> eClass_0 = this.getEClass();\n            final /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> oclAsType_1 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.emf.ecore.EClass%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, eClass_0, TYP_ecore_c_c_EClass));\n            final /*@Thrown\052/ boolean isSuperTypeOf = eReferenceType.isSuperTypeOf(oclAsType_1);\n            symbol_0 = isSuperTypeOf;\n        }\n        status = symbol_0;\n    }\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    final /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> eClass_1 = this.getEClass();\n    final /*@Thrown\052/ <%java.lang.String%> name = eClass_1.getName();\n    final /*@NonInvalid\052/ <%java.lang.String%> sum = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(<%pamtram.metamodel.MetamodelTables%>.STR_The_32_eClass_32_39, name);\n    final /*@NonInvalid\052/ <%java.lang.String%> sum_0 = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum, <%pamtram.metamodel.MetamodelTables%>.STR__39_32_is_32_not_32_allowed_32_by_32_the_32_containing_32_reference_33);\n    message_0 = sum_0;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.metamodel.MetamodelTables%>.STR_Class_c_c_eClassMatchesParentEReference, this, null, diagnostics, context, message_0, <%pamtram.metamodel.MetamodelTables%>.INT_4, CAUGHT_status, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean eClassMatchesParentEReference(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Class
