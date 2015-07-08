/*******************************************************************************
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 * using:
 *   /de.mfreund.pamtram.model/model/pamtram.genmodel
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package pamtram.transformation;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorType;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreLibraryOppositeProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorFragment;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorOperation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorPropertyWithImplementation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import pamtram.PamtramPackage;
import pamtram.PamtramTables;
import pamtram.mapping.MappingTables;
import pamtram.transformation.TransformationPackage;
import pamtram.transformation.TransformationTables;

/**
 * TransformationTables provides the dispatch tables for the transformation for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
@SuppressWarnings("nls")
public class TransformationTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final /*@NonNull*/ EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(TransformationPackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final /*@NonNull*/ ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram = IdManager.getNsURIPackageId("http://mfreund.de/pamtram", null, PamtramPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram_s_transformation = IdManager.getNsURIPackageId("http://mfreund.de/pamtram/transformation", null, TransformationPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_EObject = TransformationTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EObject", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Transformation = TransformationTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_transformation.getClassId("Transformation", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_TransformationMapping = TransformationTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_transformation.getClassId("TransformationMapping", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_TransformationModel = TransformationTables.PACKid_http_c_s_s_mfreund_de_s_pamtram.getClassId("TransformationModel", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_EObject = TypeId.ORDERED_SET.getSpecializedId(TransformationTables.CLSSid_EObject);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_TransformationMapping = TypeId.ORDERED_SET.getSpecializedId(TransformationTables.CLSSid_TransformationMapping);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			TransformationTables.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TransformationTables::TypeParameters and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The type descriptors for each type.
	 */
	public static class Types {
		static {
			Init.initStart();
			TypeParameters.init();
		}

		public static final /*@NonNull*/ EcoreExecutorType _Transformation = new EcoreExecutorType(TransformationPackage.Literals.TRANSFORMATION, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _TransformationMapping = new EcoreExecutorType(TransformationPackage.Literals.TRANSFORMATION_MAPPING, PACKAGE, 0);

		private static final /*@NonNull*/ EcoreExecutorType[] types = {
			_Transformation,
			_TransformationMapping
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TransformationTables::Types and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The fragment descriptors for the local elements of each type and its supertypes.
	 */
	public static class Fragments {
		static {
			Init.initStart();
			Types.init();
		}

		private static final /*@NonNull*/ ExecutorFragment _Transformation__OclAny = new ExecutorFragment(Types._Transformation, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Transformation__OclElement = new ExecutorFragment(Types._Transformation, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _Transformation__Transformation = new ExecutorFragment(Types._Transformation, TransformationTables.Types._Transformation);

		private static final /*@NonNull*/ ExecutorFragment _TransformationMapping__DeactivatableElement = new ExecutorFragment(Types._TransformationMapping, PamtramTables.Types._DeactivatableElement);
		private static final /*@NonNull*/ ExecutorFragment _TransformationMapping__MappingType = new ExecutorFragment(Types._TransformationMapping, MappingTables.Types._MappingType);
		private static final /*@NonNull*/ ExecutorFragment _TransformationMapping__NamedElement = new ExecutorFragment(Types._TransformationMapping, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _TransformationMapping__OclAny = new ExecutorFragment(Types._TransformationMapping, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _TransformationMapping__OclElement = new ExecutorFragment(Types._TransformationMapping, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _TransformationMapping__TransformationMapping = new ExecutorFragment(Types._TransformationMapping, TransformationTables.Types._TransformationMapping);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TransformationTables::Fragments and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The parameter lists shared by operations.
	 */
	public static class Parameters {
		static {
			Init.initStart();
			Fragments.init();
		}


		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TransformationTables::Parameters and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The operation descriptors for each operation of each type.
	 */
	public static class Operations {
		static {
			Init.initStart();
			Parameters.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TransformationTables::Operations and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The property descriptors for each property of each type.
	 */
	public static class Properties {
		static {
			Init.initStart();
			Operations.init();
		}

		public static final /*@NonNull*/ ExecutorProperty _Transformation__id = new EcoreExecutorProperty(TransformationPackage.Literals.TRANSFORMATION__ID, Types._Transformation, 0);
		public static final /*@NonNull*/ ExecutorProperty _Transformation__name = new EcoreExecutorProperty(TransformationPackage.Literals.TRANSFORMATION__NAME, Types._Transformation, 1);
		public static final /*@NonNull*/ ExecutorProperty _Transformation__transformationMapping = new EcoreExecutorProperty(TransformationPackage.Literals.TRANSFORMATION__TRANSFORMATION_MAPPING, Types._Transformation, 2);

		public static final /*@NonNull*/ ExecutorProperty _TransformationMapping__sourceMElement = new EcoreExecutorProperty(TransformationPackage.Literals.TRANSFORMATION_MAPPING__SOURCE_MELEMENT, Types._TransformationMapping, 0);
		public static final /*@NonNull*/ ExecutorProperty _TransformationMapping__targetMElement = new EcoreExecutorProperty(TransformationPackage.Literals.TRANSFORMATION_MAPPING__TARGET_MELEMENT, Types._TransformationMapping, 1);
		public static final /*@NonNull*/ ExecutorProperty _TransformationMapping__Transformation__transformationMapping = new ExecutorPropertyWithImplementation("Transformation", Types._TransformationMapping, 2, new EcoreLibraryOppositeProperty(TransformationPackage.Literals.TRANSFORMATION__TRANSFORMATION_MAPPING));
		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TransformationTables::Properties and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The fragments for all base types in depth order: OclAny first, OclSelf last.
	 */
	public static class TypeFragments {
		static {
			Init.initStart();
			Properties.init();
		}

		private static final /*@NonNull*/ ExecutorFragment[] _Transformation =
		{
			Fragments._Transformation__OclAny /* 0 */,
			Fragments._Transformation__OclElement /* 1 */,
			Fragments._Transformation__Transformation /* 2 */
		};
		private static final /*@NonNull*/ int[] __Transformation = { 1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _TransformationMapping =
		{
			Fragments._TransformationMapping__OclAny /* 0 */,
			Fragments._TransformationMapping__OclElement /* 1 */,
			Fragments._TransformationMapping__DeactivatableElement /* 2 */,
			Fragments._TransformationMapping__NamedElement /* 2 */,
			Fragments._TransformationMapping__MappingType /* 3 */,
			Fragments._TransformationMapping__TransformationMapping /* 4 */
		};
		private static final /*@NonNull*/ int[] __TransformationMapping = { 1,1,2,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._Transformation.initFragments(_Transformation, __Transformation);
			Types._TransformationMapping.initFragments(_TransformationMapping, __TransformationMapping);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TransformationTables::TypeFragments and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of local operations or local operation overrides for each fragment of each type.
	 */
	public static class FragmentOperations {
		static {
			Init.initStart();
			TypeFragments.init();
		}

		private static final /*@NonNull*/ ExecutorOperation[] _Transformation__Transformation = {};
		private static final /*@NonNull*/ ExecutorOperation[] _Transformation__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _Transformation__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _TransformationMapping__TransformationMapping = {};
		private static final /*@NonNull*/ ExecutorOperation[] _TransformationMapping__DeactivatableElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _TransformationMapping__MappingType = {};
		private static final /*@NonNull*/ ExecutorOperation[] _TransformationMapping__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _TransformationMapping__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _TransformationMapping__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._Transformation__OclAny.initOperations(_Transformation__OclAny);
			Fragments._Transformation__OclElement.initOperations(_Transformation__OclElement);
			Fragments._Transformation__Transformation.initOperations(_Transformation__Transformation);

			Fragments._TransformationMapping__DeactivatableElement.initOperations(_TransformationMapping__DeactivatableElement);
			Fragments._TransformationMapping__MappingType.initOperations(_TransformationMapping__MappingType);
			Fragments._TransformationMapping__NamedElement.initOperations(_TransformationMapping__NamedElement);
			Fragments._TransformationMapping__OclAny.initOperations(_TransformationMapping__OclAny);
			Fragments._TransformationMapping__OclElement.initOperations(_TransformationMapping__OclElement);
			Fragments._TransformationMapping__TransformationMapping.initOperations(_TransformationMapping__TransformationMapping);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TransformationTables::FragmentOperations and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of local properties for the local fragment of each type.
	 */
	public static class FragmentProperties {
		static {
			Init.initStart();
			FragmentOperations.init();
		}

		private static final /*@NonNull*/ ExecutorProperty[] _Transformation = {
			TransformationTables.Properties._Transformation__id,
			TransformationTables.Properties._Transformation__name,
			TransformationTables.Properties._Transformation__transformationMapping
		};

		private static final /*@NonNull*/ ExecutorProperty[] _TransformationMapping = {
			TransformationTables.Properties._TransformationMapping__sourceMElement,
			TransformationTables.Properties._TransformationMapping__targetMElement,
			TransformationTables.Properties._TransformationMapping__Transformation__transformationMapping
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._Transformation__Transformation.initProperties(_Transformation);
			Fragments._TransformationMapping__TransformationMapping.initProperties(_TransformationMapping);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TransformationTables::FragmentProperties and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of enumeration literals for each enumeration.
	 */
	public static class EnumerationLiterals {
		static {
			Init.initStart();
			FragmentProperties.init();
		}

		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TransformationTables::EnumerationLiterals and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 * The multiple packages above avoid problems with the Java 65536 byte limit but introduce a difficulty in ensuring that
	 * static construction occurs in the disciplined order of the packages when construction may start in any of the packages.
	 * The problem is resolved by ensuring that the static construction of each package first initializes its immediate predecessor.
	 * On completion of predecessor initialization, the residual packages are initialized by starting an initialization in the last package.
	 * This class maintains a count so that the various predecessors can distinguish whether they are the starting point and so
	 * ensure that residual construction occurs just once after all predecessors.
	 */
	private static class Init {
		/**
		 * Counter of nested static constructions. On return to zero residual construction starts. -ve once residual construction started.
		 */
		private static int initCount = 0;

		/**
		 * Invoked at the start of a static construction to defer residual cobstruction until primary constructions complete.
		 */
		private static void initStart() {
			if (initCount >= 0) {
				initCount++;
			}
		}

		/**
		 * Invoked at the end of a static construction to activate residual cobstruction once primary constructions complete.
		 */
		private static void initEnd() {
			if (initCount > 0) {
				if (--initCount == 0) {
					initCount = -1;
					EnumerationLiterals.init();
				}
			}
		}
	}

	static {
		Init.initEnd();
	}

	/*
	 * Force initialization of outer fields. Inner fields are lazily initialized.
	 */
	public static void init() {}
}
