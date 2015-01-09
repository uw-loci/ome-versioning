/*
 * #%L
 * OME-XML library extension for document versioning.
 * %%
 * Copyright (C) 2012 - 2015 Open Microscopy Environment:
 * 	- Board of Regents of the University of Wisconsin-Madison
 * 	- Glencoe Software, Inc.
 * 	- University of Dundee
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

package ome.xml.version;

/**
 * Displays a small information dialog about the project.
 *
 * @author Curtis Rueden
 */
public final class About {

	// -- Constants --

	/** URL for OME-XML versioning web page. */
	public static final String URL_OME_VERSIONING =
		"http://www.openmicroscopy.org/"
			+ "site/support/file-formats/ome-xml-versioning";

	// -- Static utility methods --

	public static String about() {
		final StringBuilder sb = new StringBuilder();
		final String nl = System.getProperty("line.separator");
		sb.append("OME-XML versioning extension" + nl);
		sb.append(nl);
		sb.append("Copyright (C) 2012 Open Microscopy Environment:" + nl);
		sb.append("  - Board of Regents " +
			"of the University of Wisconsin-Madison" + nl);
		sb.append("  - Glencoe Software, Inc." + nl);
		sb.append("  - University of Dundee" + nl);
		sb.append(nl);
		sb.append(URL_OME_VERSIONING + nl);
		sb.append(nl);
		sb.append("Authors: Kristin Briney, Curtis Rueden" + nl);
		sb.append("Advisors: Roger Leigh, Josh Moore, Andrew Patterson" + nl);
		return sb.toString();
	}

}
