// Copyright 2012 Andy Boothe
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.sigpwned.ldraw4j.x;

public class RuntimeLDRAWException extends RuntimeException {
	private static final long serialVersionUID = -8843217954775419568L;

	public RuntimeLDRAWException(String message) {
		super(message);
	}

	public RuntimeLDRAWException(Exception cause) {
		super(cause);
	}

	public RuntimeLDRAWException(String message, Exception cause) {
		super(message, cause);
	}
}
