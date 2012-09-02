/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.saansol.algorithms.recursion;

/**
 * 
 * 
 * <b>Problem Statement:</b> Given a string, print all the combinations of that
 * string. e.g. if the input is "ABC" Then output should be A, B, C, AB, BC, CD,
 * BD, ABC
 * 
 * @author Abhijit Shingate
 * 
 */
public class Combination {

	public static void combination(String input, String current, int lastIndex) {
		int length = input.length();
		if (lastIndex >= length - 1) {
			return;
		}
		for (int i = lastIndex + 1; i < length; i++) {
			String x = current + input.charAt(i);
			System.out.println(x);
			combination(input, x, i);
		}
	}

}
