/*
 * Copyright (C) 2013 The Android Open Source Project 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */

package com.military.quizthirtysixthree;
class Review {
	private int ID;
	private String QUESTION;
	private String OPTA;
	private String OPTB;
	private String OPTC;
	private String OPTD;
	private String ANSWER;
	private String REFERENCE;

// --Commented out by Inspection START (12/3/2014 4:00 PM):
// --Commented out by Inspection START (12/3/2014 4:00 PM):
////	public Review()
////	{
////		ID=0;
////		QUESTION="";
////		OPTA="";
////		OPTB="";
////		OPTC="";
////		OPTD="";
////		ANSWER="";
////		REFERENCE="";
////
////	}
//// --Commented out by Inspection STOP (12/3/2014 4:00 PM)
//	public Review(String qUESTION, String oPTA, String oPTB, String oPTC,
//			String optd, String answer, String reference) {
//
//		QUESTION = qUESTION;
//		OPTA = oPTA;
//		OPTB = oPTB;
//		OPTC = oPTC;
//		OPTD = optd;
//		ANSWER = answer;
//		REFERENCE=reference;
//	}
// --Commented out by Inspection STOP (12/3/2014 4:00 PM)

	public int getID()
	{
		return ID;
	}
	public String getQUESTION() {
		return QUESTION;
	}
	public String getOPTA() {
		return OPTA;
	}
	public String getOPTB() {
		return OPTB;
	}
	public String getOPTC() {
		return OPTC;
	}
	public String getOPTD() {
		return OPTD;
	}
	public String getANSWER() {
		return ANSWER;
	}
	public String getREFERENCE() {
		return REFERENCE;
	}
	public void setID(int id)
	{
		ID=id;
	}
	public void setQUESTION(String qUESTION) {
		QUESTION = qUESTION;
	}
	public void setOPTA(String oPTA) {
		OPTA = oPTA;
	}
	public void setOPTB(String oPTB) {
		OPTB = oPTB;
	}
	public void setOPTC(String oPTC) {
		OPTC = oPTC;
	}
	public void setOPTD(String oPTD) {
		OPTD = oPTD;
	}
	public void setANSWER(String aNSWER) {
		ANSWER = aNSWER;
	}
	public void setREFERENCE(String reference) {
		REFERENCE = reference;
	}
	
}
