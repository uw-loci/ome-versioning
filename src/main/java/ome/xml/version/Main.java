/*
 * #%L
 * OME-XML library extension for document versioning.
 * %%
 * Copyright (C) 2012 - 2014 Open Microscopy Environment:
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

import difflib.Delta;
import difflib.DiffUtils;
import difflib.Patch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Main entry point into the OME-XML injector.
 *
 * @author Curtis Rueden
 */
public final class Main {

  /** Helper method for get the file content. */
  private static List<String> fileToLines(String filename) {
          List<String> lines = new LinkedList<String>();
          String line = "";
          try {
                  BufferedReader in = new BufferedReader(new FileReader(filename));
                  while ((line = in.readLine()) != null) {
                          lines.add(line);
                  }
          } catch (IOException e) {
                  e.printStackTrace();
          }
          return lines;
  }
  
  // -- Main method --

  public static void main(String[] args) {
    List<String> original = fileToLines(args[0]);
    List<String> revised  = fileToLines(args[2]);
    
    // Compute diff. Get the Patch object. Patch is the container for computed deltas.
    Patch patch = DiffUtils.diff(original, revised);

    try {
      BufferedWriter out = new BufferedWriter(new FileWriter(args[4]));
      for (Delta delta: patch.getDeltas()) {
        out.write(delta.toString());
        //out.write(args[0]);
        }
      out.close();
      } catch (IOException e) {
      e.printStackTrace();
      }
  }

}
