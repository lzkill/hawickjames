# Hawick and James Algorithm [![Build Status](https://api.travis-ci.org/lzkill/hawickjames.svg?branch=master)](https://api.travis-ci.org/lzkill/hawickjames)

Released: Jun, 2014</p>

Written by [Luiz Kill](mailto:me@lzkill.com) and Contributors

## Introduction ##

This is a Java implementation of the simple cycle enumeration algorithm described by Hawick and James.

*A. Hawick, H. A. James. Enumerating Circuits and Loops in Graphs with Self-Arcs and Multiple-Arcs. Computational Science Technical Note CSTN-013, 2008.*

It's built on top of JGraphT, so may be used under the terms of either the

 * GNU Lesser General Public License (LGPL) 2.1
   http://www.gnu.org/licenses/lgpl-2.1.html

or the

 * Eclipse Public License (EPL)
   http://www.eclipse.org/org/documents/epl-v10.php

As a recipient you may choose
which license to receive the code under.

For a detailed information on the dual license approach, see https://github.com/jgrapht/jgrapht/wiki/Relicensing.

A copy of the [EPL license](license-EPL.txt) and the [LPGL license](license-LGPL.txt) is included in the download.

Please note that this code is distributed WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

Please refer to the license for details.

## Dependencies ##

- [JGraphT](http://www.jgrapht.org) is a free Java graph library that provides mathematical graph-theory objects and algorithms.
- [JUnit](http://www.junit.org) is a unit testing framework. You need JUnit only if you want to run the unit tests. JUnit is licensed under the terms of the IBM Common Public License.
- [Commons Lang](http://commons.apache.org/proper/commons-lang/) provides a host of helper utilities for the java.lang API, notably String manipulation methods, basic numerical methods, object reflection, concurrency, creation and serialization and System properties. 
You need this only if you want to load some graph from a file. The file must contain a edge per line, in the format *"from;target"*

## Your Improvements ##

If you add improvements to this code please send them to me as pull requests on github. I will add them to the next release so that everyone can enjoy them. You might also benefit from it: others may fix bugs in your source files or may continue to enhance them.

## Thanks ##

With regards from

[Luiz Kill](mailto:me@lzkill.com) 
