/**
 *  Copyright 2018 Visionary Research Inc.   All rights reserved.
 *    			legal@visionary-research.com
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *    
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License. 
 */
/* xhist debug FALSE */	/*<DEBUG OFF>*/

import java.lang.Runtime;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import XMT.Xhist;

public	class		Hello
{
    public static final String id = "@(#) hello.Hello $Version: meshtest-1.0-16 [develop] $";

    public static void main(String []args) {

	/* xhist instrument FALSE */
	int i;
	DataOutputStream	fd;
    
	try {
	    fd = new DataOutputStream(new FileOutputStream("./Hello.trace")); 
	    Xhist.logdev(fd);
	    Xhist.mapfile("$XhistMap: Hello.java.map $");
	    Xhist.version("$Version: meshtest-1.0-16 [develop] $");

	    Runtime.getRuntime().addShutdownHook( new Thread() {
		@Override
		public void run() {
		    try {
			Xhist.write();
		    }
		    catch (java.io.IOException e) {
			/* do nothing */
		    }
		}
	    });
	} 
	catch (java.io.FileNotFoundException e) {
	    System.out.println("cannot open DataOutputStream");
	    /* continue */
	}
	/* xhist instrument TRUE */

	for (i = 0; i < 10; i++)
	{ 
	    try { 
		Thread.sleep(1000); Xhist.add( 49396, 58 );
	    } 
	    catch (InterruptedException e) {
	        /* do nothig */
	    }
	    foo();Xhist.add( 49396, 63 );
	} 
    }

    public static void foo() {
        System.out.println("hello foo");Xhist.add( 49396, 68 );
    }

}