/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package pamtram.util;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

import de.tud.et.ifa.agtele.emf.connecting.AllowedReferenceType;

/**
 * A utility class that provides enhanced support in comparison to {@link de.tud.et.ifa.agtele.emf.XSDAnyContentUtil}.
 *
 * @author mfreund
 */
@SuppressWarnings("javadoc")
public class XSDAnyContentUtil {

	private XSDAnyContentUtil() {

	}

	public static Optional<EReference> getOrCreateVirtualAnyContentReference(EClass parentEClass) {

		EReference xsAnyReference = null;

		if (de.tud.et.ifa.agtele.emf.XSDAnyContentUtil.allowsAnyContent(parentEClass)) {
			xsAnyReference = de.tud.et.ifa.agtele.emf.XSDAnyContentUtil
					.getOrCreateVirtualAnyContentReference(parentEClass);

			if (xsAnyReference != null && !parentEClass.getEStructuralFeatures().contains(xsAnyReference)) {
				// prevents 'dangling HREF' exceptions when saving the PAMTraM model
				parentEClass.getEStructuralFeatures().add(xsAnyReference);

			}
		}

		return Optional.ofNullable(xsAnyReference);
	}

	public static List<EReference> getEAllReferencesIncludingVirtualAnyContentReference(EClass eClass) {

		return getEAllReferencesIncludingVirtualAnyContentReference(eClass, AllowedReferenceType.BOTH);
	}

	public static List<EReference> getEAllReferencesIncludingVirtualAnyContentReference(EClass eClass,
			AllowedReferenceType allowedReferenceType) {

		Set<EReference> allOutgoingReferences = new LinkedHashSet<>(eClass.getEAllReferences());

		// for classes based on an xsd element with content of type 'xs:any'
		Optional<EReference> xsAnyReference = pamtram.util.XSDAnyContentUtil
				.getOrCreateVirtualAnyContentReference(eClass);
		if (xsAnyReference.isPresent()) {
			allOutgoingReferences.add(xsAnyReference.get());
		}

		if (AllowedReferenceType.CONTAINMENT == allowedReferenceType) {
			return allOutgoingReferences.stream().filter(EReference::isContainment).collect(Collectors.toList());
		} else if (AllowedReferenceType.NONCONTAINMENT == allowedReferenceType) {
			return allOutgoingReferences.stream().filter(r -> !r.isContainment()).collect(Collectors.toList());
		} else {
			return new ArrayList<>(allOutgoingReferences);
		}
	}
}
