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
import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Establish SQLite database and loads information into database.
 */

class DbHelper extends SQLiteOpenHelper {
	
	// --Commented out by Inspection (12/3/2014 3:59 PM):Question currentQ;
	// --Commented out by Inspection (12/3/2014 4:00 PM):int qid=0;
	
	private static final int DATABASE_VERSION = 16; //Update number to call onUpgrade method
	// Database Name
	private static final String DATABASE_NAME = "thirtysixthree";
	// tasks table name
	private static final String TABLE_NAME = "thirtysixthree";
	// tasks Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_QUES = "question";
	private static final String KEY_ANSWER = "answer"; //correct option
	private static final String KEY_REFERENCE = "reference";// Regulation Reference
	private static final String KEY_OPTA= "opta"; //option a
	private static final String KEY_OPTB= "optb"; //option b
	private static final String KEY_OPTC= "optc"; //option c
	private static final String KEY_OPTD= "optd"; //option d
	private SQLiteDatabase dbase;

    public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

    /* Creates database and adds information */
	@Override
	public void onCreate(SQLiteDatabase db) {

		dbase=db;
		//onUpgrade(db, 1, 2);
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
				+KEY_OPTB +" TEXT, "+KEY_OPTC +" TEXT, "+KEY_OPTD +" TEXT, "+KEY_REFERENCE +" TEXT )";
		db.execSQL(sql);		
		addQuestions();
		//db.close();
	}
    /** Adds data to database */
	
	private void addQuestions() {
        //Constructor format (Question, Option A, Option B, Option C, Option D, Answer, Reference)
        //Chapter 1
        Question q1 = new Question("What are duty hours? (Mon-Fri)", "0545-1800", "0530-1830", "0500-1700", "0515-1715", "0545-1800", "Para 1.17.3.1");//A
        this.addQuestion(q1);
        Question q2 = new Question("What are after duty hours? (Mon-Fri, weekends and holidays)", "1730-0530", "1800-0545", "1700-0500", "1830-0530", "1800-0545", "Para 1.17.3.2");//B
        this.addQuestion(q2);
        Question q3 = new Question("Squadron Senior Leadership Team (including Flight Commanders) will conduct how many hours of analog leadership per week? (During duty hours)", "10 hours", "8 hours", "6 hours", "7 hours", "10 hours", "Para 1.17.3.1");//A
        this.addQuestion(q3);
        Question q4 = new Question("Squadron Senior Leadership Team (including Flight Commanders) will conduct how many hours of analog leadership per week? (During after duty hours)", "5 hours", "6 hours", "7 hours", "9 hours", "7 hours", "Para 1.17.3.2");//C
        this.addQuestion(q4);
        //Chapter 2
        Question q5 = new Question("Dirty linen must be turned into PT/Supply linen exchange point prior to ____?", "0800", "0730", "0700", "0630", "0730", "Para 2.1.3");//B
        this.addQuestion(q5);
        Question q6 = new Question("(Linen Exchange) Sheets are bundled _____________.", "10 (9 inside of 1)", "3 (2 inside of 1)", "20 (19 inside of 1)", "Even depending on total", "10 (9 inside of 1)", "Para 2.1.2");//A
        this.addQuestion(q6);
        Question q7 = new Question("(Linen Exchange) Mattress covers are bundled ___________.", "10 (9 inside of 1)", "3 (2 inside of 1)", "20 (19 inside of 1)", "Even depending on total", "10 (9 inside of 1)", "Para 2.1.2");//A
        this.addQuestion(q7);
        Question q8 = new Question("(Linen Exchange) Pillow cases are bundled __________.", "10 (9 inside of 1)", "3 (2 inside of 1)", "20 (19 inside of 1)", "Even depending on total", "20 (19 inside of 1)", "Para 2.1.2");//C
        this.addQuestion(q8);
        Question q9 = new Question("(Linen Exchange) Blankets are bundled ___________", "10 (9 inside of 1)", "3 (2 inside of 1)", "20 (19 inside of 1)", "Even depending on total", "3 (2 inside of 1)", "Para 2.1.2");//B
        this.addQuestion(q9);
        Question q10 = new Question("When are mattresses immediately swapped out?", "Weekly", "Monthly", "When the flight ships", "When safety or health issues arise", "When safety or health issues arise", "Para 2.1.4");//D
        this.addQuestion(q10);
        Question q11 = new Question("All shipping flights must turn in dirty linen on shipping day by __________.", "0630", "0700", "0730", "0800", "0630", "Para 2.1.5");//A
        this.addQuestion(q11);
        Question q12 = new Question("All contaminated linen must be placed in ___________ and turned in to squadron PT/Supply.", "one black plastic bag", "two black plastic bags", "one brown plastic bag", "two brown plastic bags", "two brown plastic bags", "Para 2.1.6");//D
        this.addQuestion(q12);
        Question q13 = new Question("Trainees acknowledge receipt of their ABU IRS Parka/Liner by signing which roster?", "Clothing Inventory Roster", "ABU IRS Parka/Liner Issue", "Parka/Liner Roster", "Military Clothing Issue", "ABU IRS Parka/Liner Issue", "Para 2.2.1.2");//B
        this.addQuestion(q13);
        Question q14 = new Question("Trainees that have a defective or improperly fitted ABU IRS Parka report to the BMT Reception Center when?", "Monday-Wednesday of the 1 WOT between 0900-1200", "Wednesday-Friday of the 1 WOT between 0900-1200", "Monday-Wednesday of the 2 WOT between 0900-1200", "Monday-Wednesday of the 1 WOT between 1200-1500", "Monday-Wednesday of the 1 WOT between 0900-1200", "Para 2.2.2.1");//A
        this.addQuestion(q14);
        Question q15 = new Question("If a trainees ABU IRS Parka is stolen, what form must be completed?", "AF FORM 124", "AF FORM 659", "AF FORM 54", "AF FORM 543", "AF FORM 659", "Para 2.2.4");//B
        this.addQuestion(q15);
        Question q16 = new Question("Who is responsible for issuing Student Leader/Chapel Guide Badges?", "PT/Supply", "Instructor Supervisor", "Flight Commander", "CQ", "PT/Supply", "Para 2.3.1");//A
        this.addQuestion(q16);
        Question q17 = new Question("Trainees wear position badges _________?", "centered and grounded to US Airforce Tape or left breast pocket", "centered and grounded to nametape or right breast pocket", "1 inch above the left breast pocket and centered", "1 inch above the right breast pocket and centered", "centered and grounded to nametape or right breast pocket", "Para 2.3.4");//B
        this.addQuestion(q17);
        Question q18 = new Question("Trainee position badges are worn in ABU's and which of the following uniforms?", "PT Gear", "Blues Service Uniform", "Blues Full Service Dress", "None of the above", "None of the above", "Para 2.3.5");//D
        this.addQuestion(q18);
        Question q19 = new Question("Trainee wear canteens during all outside activities except:", "Flight Drill", "Negotiating obstacles at the BMT Obstacle Course", "PT", "All of the above", "All of the above", "Para 2.4.1");//D
        this.addQuestion(q19);
        Question q20 = new Question("Canteens are sanitized how often?", "Daily", "Weekly", "Monthly", "Bi-Monthly", "Weekly", "Para 2.4.2");//B
        this.addQuestion(q20);
        Question q21 = new Question("Canteen covers will be marked with which of the following items?", "Squadron, Dormitory, and Bed number only", "Squadron, Floor, and Bed number only", "Building number, Dormitory, and Bed number only", "Squadron, Dormitory and Roster number", "Squadron, Dormitory, and Bed number only", "Para 1.1");
        this.addQuestion(q21);
        Question q22 = new Question("Trainee who do not appear on the Stripe Roster but claim they are to be promoted upon graduation, are sent to BLDG _____, Room _____ for promotion verification.", "5725 / 113", "5725 / 115", "5616 / 205", "5616 / 195", "5725 / 113", "Para 2.5.2");//A
        this.addQuestion(q22);
        Question q23 = new Question("Airmen begin wearing all authorized ribbons and chevrons when?", "Retreat Ceremony", "Graduation Day Parade", "8 WOT", "After shipping", "Graduation Day Parade", "Para 2.5.3");//B
        this.addQuestion(q23);
        Question q24 = new Question("Where are extra copies of the BMTDG stored?", "PT/Supply", "Empty Wall Lockers", "Civilian Luggage Room", "Flight Office", "Civilian Luggage Room", "Para 2.6.2");//C
        this.addQuestion(q24);
        Question q25 = new Question("(1st Clothing Issue) Trainees return to Clothing Issue NLT the end of the ________ for any missing, improperly fit or defective clothing items.", "1 WOT", "2 WOT", "3 WOT", "4 WOT", "1 WOT", "Para 2.8.1");//A
        this.addQuestion(q25);
        Question q26 = new Question("(2nd Clothing Issue) Trainees return to Clothing Issue NLT end of ______ for missing, improperly fit or defective clothing items.", "4 WOT", "5 WOT", "7 WOT", "8 WOT", "5 WOT", "Para 2.8.2");//B
        this.addQuestion(q26);
        Question q27 = new Question("When should trainees be sent to Clothing Issue to exchange or be issued items?", "Anytime during a duty day", "Call for appointment", "At 0630 with any flight processing", "Monday-Tuesday: 0730-1630 and Wednesday-Friday: 1430-1630", "Monday-Tuesday: 0730-1630 and Wednesday-Friday: 1430-1630", "Para 1.1");//D
        this.addQuestion(q27);
        Question q28 = new Question("No boot/shoe exchange letter is required if:", "Boots/shoes are defective (marked or unmarked)", "Boots/shoes are not marked", "A and B", "A letter is always required", "A and B", "Para 2.8.3.1");
        this.addQuestion(q28);
        Question q29 = new Question("An exchange letter is required if:", "the boots/shoes are marked and were improperly fitted", "extra boots are wanted", "A letter is always required", "A letter is never required", "the boots/shoes are marked and were improperly fitted", "Para 2.8.3.1.3");//A
        this.addQuestion(q29);
        Question q30 = new Question("Low quarters must be exchanged NLT", "Wednesday of the 8 WOT", "Tuesday of the 8 WOT", "Thursday of the 8 WOT", "Monday of the 8 WOT", "Monday of the 8 WOT", "Para 2.8.3.1.3");//D
        this.addQuestion(q30);
        Question q31 = new Question("Make-Up Clothing Issue (trainees who did not process with their flight for 2nd Issue) is conducted Monday - Friday from 0630-1430, trainees must arrive by ________.", "0600", "0630", "0700", "0800", "0630", "Para 2.8.4");//B
        this.addQuestion(q31);
        Question q32 = new Question("Trainees report to their military training instructor within ___ duty days after the incident to ensure the damaged uniform item is replaced prior to shipping.", "1", "2", "3", "4", "2", "Para 2.8.6.3");//B
        this.addQuestion(q32);
        Question q33 = new Question("Mark beds on the inspection side, ___ inches from the center aisle end of the frame on the bed rail.", "1", "2", "3", "4", "3", "Para 2.11.2");//C
        this.addQuestion(q33);
        Question q34 = new Question("Authority to Enter boards will contain _______________", "Instructor Team", "Squadron Supervisory Personnel", "Both A and B", "Entire Squadron", "Both A and B", "Para 2.12.1");//C
        this.addQuestion(q34);
        Question q35 = new Question("Keep windows and doors closed", "When AC is on", "During winter months", "Unless very high temperatures occur", "All the above", "All the above", "Para 2.13.1");//D
        this.addQuestion(q35);
        Question q36 = new Question("Notify the Charge of Quarters (CQ) when the dormitory temperature is: ", "greater than 75 degrees or lower than 68 degrees", "greater than 77 degrees or lower than 67 degrees", "greater than 70 degrees or lower than 60 degrees", "greater than 80 degrees or lower than 70 degrees", "greater than 75 degrees or lower than 68 degrees", "Para 2.13.1.4");//A
        this.addQuestion(q36);
        Question q37 = new Question("Extra light bulbs for use in the dormitory are stored: ", "In the flight office", "Light bulbs are not stored in the dormitory", "In the civilian luggage room", "In the utility room", "Light bulbs are not stored in the dormitory", "Para 2.13.2.4");//B
        this.addQuestion(q37);
        Question q38 = new Question("Store trainee ironing boards in the _________.", "Utility Room", "Dayroom", "Wall Locker", "Flight Office", "Dayroom", "Para 2.14.4");//B
        this.addQuestion(q38);
        Question q39 = new Question("Doors into dayrooms from inside the dormitory remain closed: ", "During lights out", "During down time", "When the flight is at BEAST", "All the above", "All the above", "Para 2.14.6");//D
        this.addQuestion(q39);
        Question q40 = new Question("When in the dormitory, road guards will place road guard vests", "in the Utility Room", "in their BMTSG pouch", "in their Security Drawer", "in their cargo pocket", "in the Utility Room", "Para 2.14.7");//A
        this.addQuestion(q40);
        Question q41 = new Question("Position the first bed in each element approximately __ inches from the front wall or water fountain.", "30", "36", "24", "48", "24", "Figure 2.1, Note 2");//C
        this.addQuestion(q41);
        Question q42 = new Question("Align the side of the last bed in each element (closest to back wall): ", " with the outermost portion of the last wall locker in 2d and 3d element.", "24 inches from the back wall", "36 inches from the back wall", "Even with the bed across from it", " with the outermost portion of the last wall locker in 2d and 3d element.", "Figure 2.1, Note 3");//A
        this.addQuestion(q42);
        Question q43 = new Question("The ______________________ is a required visual aid and must be prominently displayed in each dormitory dayroom.", "Rank Visual Aid", "Airman's Creed (acrylic poster)", "PT Charts", "Flight EAL", "Airman's Creed (acrylic poster)", "Figure 2.3 Note");//B
        this.addQuestion(q43);
        //Chapter 3
        Question q44 = new Question("Basic training line squadron duty hours are: ", "0545-2100", "0545-1730", "0545-2000", "0545-1600", "0545-2100", "Para 3.4.1");//A
        this.addQuestion(q44);
        Question q45 = new Question("Squadron leadership monitors and justifies MTI/staff duty that exceeds __ hours in one day.", "10", "11", "12", "9", "10", "Para 3.4.2.1");//A
        this.addQuestion(q45);
        Question q46 = new Question("Squadron leadership monitors and justifies MTI/staff duty that exceeds __ hours in one week.", "40", "50", "60", "80", "60", "Para 3.4.2.1");//C
        this.addQuestion(q46);
        Question q47 = new Question("Squadron leadership monitors and justifies MTI/staff duty that exceeds __ days consecutively.", "7", "9", "10", "12", "7", "Para 3.4.2.1");//A
        this.addQuestion(q47);
        Question q48 = new Question("All line squadrons (including the 324 TRS) MTIs and staff are required to sign in and out for duty at __.", "DO", "FC", "IS", "CQ", "CQ", "Para 3.4.2.2");//D
        this.addQuestion(q48);
        Question q49 = new Question("CQ monitors BTMS Workload to identify individuals at the __ hour mark and reports information to squadron supervisory personnel.", "12", "8", "9", "10", "9", "Para 3.4.2.4");//C
        this.addQuestion(q49);
        Question q50 = new Question("Who has the authority to approve duty hours that will exceed 10 hours?", "Flight Commander or higher", "Team Chief or higher", "Instructor Supervisor or higher", "Director of Operations or higher", "Flight Commander or higher", "Para 3.4.2.5");//A
        this.addQuestion(q50);
        Question q51 = new Question("Same gender MTIs must depart the dormitory NLT ______?", "2100", "2030", "2000", "1930", "2100", "Para 3.4.3.1");//A
        this.addQuestion(q51);
        Question q52 = new Question("Same gender MTIs are not authorized to enter the dorm until _______.", "0515", "0545", "0530", "0600", "0545", "Para 3.4.3.1");//B
        this.addQuestion(q52);
        Question q53 = new Question("Opposite gender MTIs must depart dorm NLT ____", "2000", "2015", "2030", "2100", "2030", "Para 3.4.3.2");//C
        this.addQuestion(q53);
        Question q54 = new Question("Opposite gender MTIs are not authorized to enter the dorm until ____.", "0515", "0530", "0545", "0600", "0600", "Para 3.4.3.2");//D
        this.addQuestion(q54);
        Question q55 = new Question("Flight pick-up (receiving) after 2100, lights out and MTI departure is _____ hours after flight arrival to the dorm.", "1.5", "2", "2.5", "1", "1.5", "Para 3.4.4.2");//A
        this.addQuestion(q55);
        Question q56 = new Question("Non-duty dorm inspections conduct at night must be completed between ____________.", "2100-2130", "2130-2200", "2100-2300", "2100-2200", "2100-2200", "Para 3.4.4.3");//D
        this.addQuestion(q56);
        Question q57 = new Question("Non-duty dorm inspections conducted in the morning must be completed between _________.", "0445-0545", "0500-0545", "0500-0530", "0430-0530", "0500-0545", "Para 3.4.4.3");//B
        this.addQuestion(q57);
        Question q58 = new Question("Which of the following is NOT an authorized reason to enter a dormitory prior to 0545: ", "BEST", "2nd Clothing Issue", "PT Eval", "Parade", "PT Eval", "Para 3.4.4.6");//C
        this.addQuestion(q58);
        Question q59 = new Question("Opposite gender MTI's are authorized to be in the ______ when the flight is in a state of undress.", "Bays", "Dayroom", "Flight Office", "None of the above", "None of the above", "Para 3.4.4.7");//D
        this.addQuestion(q59);
        Question q60 = new Question("Dormitories must be in inspection order from _____________ during the winter schedule (Dec-Feb)", "0800 to 1530", "0900 to 1530", "0900 to 1630", "0830 to 1530", "0800 to 1530", "Para 3.4.6");//A
        this.addQuestion(q60);
        Question q61 = new Question("Dormitories must be in inspection order from _____________ during the summer schedule (Mar-Nov)", "1000 to 1630", "0900 to 1730", "0800 to 1530", "0900 to 1630", "0900 to 1630", "Para 3.4.6");//D
        this.addQuestion(q61);
        Question q62 = new Question("The 737 TRG Standardization Evaluation Team may inspect MTI responsibilities at any time; however, individual areas may not be inspected until ___________.", "Monday of the 1 WOT", "Monday of the 4 WOT", "Monday of the 3 WOT", "Monday of the 2 WOT", "Monday of the 3 WOT", "Para 3.4.6");//C
        this.addQuestion(q62);
        Question q63 = new Question("At least one IS, interim IS, or flight commander is on duty from ___________ Monday-Fridays,", "0500-2100", "0600-2100", "0500-2200", "0500-2000", "0500-2100", "Para 3.5.1");//A
        this.addQuestion(q63);
        Question q64 = new Question("At least one IS, interim IS, or flight commander is on duty from ___________ Saturday, Sunday and holidays", "0700-2100", "0600-2100", "0600-2100", "0630-2200", "0600-2100", "Para 3.5.1");//B
        this.addQuestion(q64);
        Question q65 = new Question("An interim IS may only perform these duties (Squadron Supervisory Coverage) when approved by the _______.", "CC/DO", "FC/SS", "FC/IS", "TS/SS", "CC/DO", "Para 3.5.2");//A
        this.addQuestion(q65);
        Question q66 = new Question("The late evening supervisor (FC or IS) will remain in the squadron until lights out and ensure all instructors have ____________________.", "not exceeded 12 hours in BTMS", "have turned in clipboards", "departed the RH&T/ATC.", "signed out of BTMS", "departed the RH&T/ATC.", "Para 3.5.5");//C
        this.addQuestion(q66);
        Question q67 = new Question("Ensure 5 WOT or above Entry Controllers of the same gender are on duty from _______ hrs, through the first weekend.", "1930 - 0530", "1830 - 0830", "2030 - 0630", "1830 - 0630", "1830 - 0630", "Para 3.6.1");//D
        this.addQuestion(q67);
        Question q68 = new Question("Entry controllers in 3-4 WOT of the same gender may be used from ________.", "0630 - 2030 hrs", "0630 - 1830 hrs", "0830 - 1830 hrs", "1830 - 0630 hrs", "0630 - 1830 hrs", "Para 3.6.1");//B
        this.addQuestion(q68);
        Question q69 = new Question("Squadrons conduct a minimum of __ hour of IHT each quarter.", "1", "2", "3", "4", "1", "Para 3.8.2");//A
        this.addQuestion(q69);
        Question q70 = new Question("Concerning 737 TRG Training Requirements, which of the following regulations requires QUARTERLY training: ", "AETCI 36-2909", "737 TRGOI 36-2205", "AFI 36-6001", "737 TRGOI 90-801", "AFI 36-6001", "Table 3.1 ");//C
        this.addQuestion(q70);
        Question q71 = new Question("Who conducts recurring CPR for all MTI's?", "Any medical personnel", "Squadron Training Manager", "Any CPR trainer", "IDMT's assigned to the 737 TRSS", "IDMT's assigned to the 737 TRSS", "Para 3.10.4");//D
        this.addQuestion(q71);
        Question q72 = new Question("AETC Form 50 is required when?", "All individual appointments not included on the WAS", "All flight appointments only", "Processing appointments only", "Out of squadron appointments only", "All individual appointments not included on the WAS", "Para 3.11.1");//A
        this.addQuestion(q72);
        Question q73 = new Question("LAFB Form 104 is used for what?", "Destruction of Trainee Personal Property", "Sign in/out of squadron", "Squadron Transfers", "Inventory/Storage of Trainee Personal Property", "Inventory/Storage of Trainee Personal Property", "Para 3.11.2");//D
        this.addQuestion(q73);
        Question q74 = new Question("AF Form 1052 is used for What?", "Envelope for Storing MTI Use Items", "Envelope for Storing Patient's Valuables", "Inventory/Storage of Trainee Personal Property", "BAS Transfer of Trainee", "Envelope for Storing Patient's Valuables", "Para 3.11.2.1");//B
        this.addQuestion(q74);
        Question q75 = new Question("BMT Form 118 must be annotated for _ consecutive days ", "5", "3", "7", "9", "5", "Para 3.11.4.1");//A
        this.addQuestion(q75);
        Question q76 = new Question("MTI must check the BMT Form 118 daily, NLT _____ (Summer Schedule)", "0600", "0700", "0900", "0800", "0800", "Para 3.11.4.2");//D
        this.addQuestion(q76);
        Question q77 = new Question("MTI must check the BMT Form 118 daily, NLT _____ (Winter Schedule)", "0600", "0700", "0900", "0800", "0700", "Para 3.11.4.2");//B
        this.addQuestion(q77);
        Question q78 = new Question("BMT Form 124, Trainees do not sign out on the appointment log for scheduled activities or __________.", "sensitive skills", "medical appointments", "clothing issue", "bx runs", "sensitive skills", "Para 3.11.6.2");//A
        this.addQuestion(q78);
        Question q79 = new Question("After the MTI briefs a trainee on the contents of a AETC Form 341, the trainee places their _______ on the form.", "payroll signature", "initials", "anything", "printed name", "initials", "Para 3.11.7.1");//C
        this.addQuestion(q79);
        Question q80 = new Question("AF Form 490 is issued by __________ and provides information for mandatory medical appointments.", "MTI", "Medical Staff", "Flight Commander", "Civilian", "Medical Staff", "Para 3.11.8.1");//B
        this.addQuestion(q80);
        //Chapter 4
        Question q81 = new Question("Line MTI's will ensure flight accountability ______________.", "at the beginning of each shift", "at the end of each shift", "at all times", "every hour", "at all times", "Para 4.1.1.");//C
        this.addQuestion(q81);
        Question q82 = new Question("Student leaders are authorized to carry rosters that do not contain ___________.", "Personally Identifiable Information", "First Names", "Last Names", "Middle Names", "Personally Identifiable Information", "Para 4.1.1. NOTE");//A
        this.addQuestion(q82);
        Question q83 = new Question("Which of the following do trainees NOT have to compare for discrepancies upon arrival/before records processing?", "SSN", "Names", "Jr/Sr/II", "Roster Number", "Roster Number", "Para 4.1.2.");//D
        this.addQuestion(q83);
        Question q84 = new Question("Which of the following are MTI's NOT required to instruct trainees on about the wingman system?", "benefits", "purpose", "violations", "rules", "violations", "Para 4.2.2.");//C
        this.addQuestion(q84);
        Question q85 = new Question("The wingman system establishes policy for pairing BMT trainees into teams to develop a sense of ___________.", "responsibility", "pride", "trust", "loyalty", "responsibility", "Para 4.2.2.");//A
        this.addQuestion(q85);
        Question q86 = new Question("The wingman system reduces the likelihood and opportunity for __________", "sexual harassment", "misconduct", "suicidal gestures/attempts", "All the above", "All the above", "Para 4.2.2.");//D
        this.addQuestion(q86);
        Question q87 = new Question("Flight MTI's will ensure trainees fill out the wingman card upon arrival to the unit but NLT COB ______________.", "Sunday of processing week", "Saturday of processing week", "Saturday of initial war skills week", "Sunday of initial war skills week", "Saturday of processing week", "Para 4.2.3.");//B
        this.addQuestion(q87);
        Question q88 = new Question("Trainees are introduced to the wingman system in BMT and formed into two types of teams:", "Primary / Alternate", "Normal / Temporary", "Primary / Temporary", "Primary / Ad-hoc", "Primary / Ad-hoc", "Para 4.2.4.1.");//D
        this.addQuestion(q88);
        Question q89 = new Question("A primary wingmen is assigned by _______?", "gender", "roster number", "AFSC", "bed number", "bed number", "Para 4.2.4.1.1.");//D
        this.addQuestion(q89);
        Question q90 = new Question("Ad-hoc wingman teams are formed when: ", "the use of primary wingman is not practical", "meeting a chaplin", "meeting a doctor", "meeting a investigator", "the use of primary wingman is not practical", "Para 4.2.4.2.1.");//A
        this.addQuestion(q90);
        Question q91 = new Question("Trainees will ensure a wingman is always in view unless: ", "with a medical provider", "with an IDMT", "meeting a chaplin", "All the above", "All the above", "Para 4.2.8 Exceptions");//D
        this.addQuestion(q91);
        Question q92 = new Question("Trainees will ensure a wingman is always in view unless: ", "meeting with a SARC", "5k/Airman's run drop-outs", "while using the restroom", "All the above", "All the above", "Para 4.2.8. Exceptions");//D
        this.addQuestion(q92);
        Question q93 = new Question("Personnel notified of a seperated wingman must inform: ", "Element Leader", "Dorm Chief", "Squadron Leadership", "MTI Team", "Squadron Leadership", "Para 4.2.9.");//C
        this.addQuestion(q93);
        Question q94 = new Question("When are MTI's authorized to drive trainees in their POV's?", "Never", "To/From Appointments", "To/From BEAST", "Red Cross Notifications", "Never", "Para 4.2.13. ");//A
        this.addQuestion(q94);
        Question q95 = new Question("MTI will never be closer than ___ of a trainee unless engaging in one of the 5 authorized physical contact reasons.", "24", "18", "12", "6", "12", "Para 4.5.1.");//C
        this.addQuestion(q95);
        Question q96 = new Question("Which two of the following are authorized reasons to make physical contact with a trainee and DO NOT require asking 'permission to touch'?", "Prevent Injury", "Attend an injured trainee", "Conduct a demonstration during authorized training", "Both A and B", "Both A and B", "Para 4.5.1.");//D
        this.addQuestion(q96);
        Question q97 = new Question("MTI's will always dress _______ or _______ than flight members?", "equal to / higher than", "equal to / lower than", "higher than / lower than", "lower than / equal to", "equal to / higher than", "Para 4.6.4");//A
        this.addQuestion(q97);
        Question q98 = new Question("Flight MTIs wear ______ and issued _______ while assigned to the BEAST.", "Campaign hat / PHS", "Campaign hat / canteen/web belt", "ABU cap / PHS", "ABU cap / canteen/web belt", "ABU cap / PHS", "Para 4.6.7.");//B
        this.addQuestion(q98);
        Question q99 = new Question("Cell phones / portable electronic devices may only be used in the presence of trainees when: ", "They can be used at any time", "Both C and D", "a training requirement warrants it", "in an emergency situation", "Both C and D", "Para 4.6.9.3.2.");//B
        this.addQuestion(q99);
        Question q100 = new Question("When transiting during nighttime and periods of reduced visibility, the entire formation, including the person in charge, must have an: ", "any type of flashlight", "a flashlight with fluorescent wand", "reflective vest", "head lamps", "a flashlight with fluorescent wand", "Para 4.7.1.2.");//B
        this.addQuestion(q100);
        Question q101 = new Question("Designate road guards for all marching units of ____ or more trainees, including the person in charge.", "11", "14", "12", "13", "13", "Para 4.7.3.2");//D
        this.addQuestion(q101);
        Question q102 = new Question("After a marching unit has cleared the intersection, they must be halted, EXCEPT if being marched by a _____________ .", "Instructor Supervisor", "Dorm Chief", "Certified MTI", "MTI in Training", "Certified MTI", "Para 4.7.3.4.4");//C
        this.addQuestion(q102);
        Question q103 = new Question("Prohibitive forms of marching e.g., goose-stepping, thunder/lighting or other forms of foot pounding are prohibited because: ", "can cause injury to lower extremities", "can cause injury to lower back", "can cause injury to shoulders", "is considered abuse", "can cause injury to lower extremities", "Para 4.7.4.11");//A
        this.addQuestion(q103);
        Question q104 = new Question("The use of Jody Calls/Jodies are highly encouraged from as early as the first day of the", "0 WOT", "1 WOT", "2 WOT", "3 WOT", "1 WOT", "Para 4.8.1");//B
        this.addQuestion(q104);
        Question q105 = new Question("Do not allow any mass vocal participation at any location before _____ hrs on Sundays and holidays except during PT.", "0830", "0900", "0730", "0800", "0730", "Para 4.8.2");//C
        this.addQuestion(q105);
        Question q106 = new Question("How many times a day must trainees wash their hands?", "5", "4", "3", "6", "5", "Para 4.9.1.1.1");//A
        this.addQuestion(q106);
        Question q107 = new Question("How long should a trainee wash their hands for?", "10 sec", "20 sec", "30 sec", "40 sec", "20 sec", "Para 4.9.1.1.1");//B
        this.addQuestion(q107);
        Question q108 = new Question("Trainees must shower __ per day during summer schedule and __ per day during winter schedule.", "2 / 1", "3 / 1 ", "2 / 2", "1 / 1", "2 / 1", "Para 4.9.1.1.3");//A
        this.addQuestion(q108);
        Question q109 = new Question("Trainees are authorized to co-utilize hygiene items ", "if they are related", "never, it is absolutely prohibited", "if they are wingman", "if authorized by Dorm Chief", "never, it is absolutely prohibited", "Para 4.9.1.1.3");//B
        this.addQuestion(q109);
        Question q110 = new Question("Canteens must be sanitized ________.", "daily", "monthly", "weekly", "once", "weekly", "Para 4.9.1.1.8");//C
        this.addQuestion(q110);
        Question q111 = new Question("Ensure trainees with upper respiratory infections wear masks at _______ ?", "at meals", "during class", "when transiting", "at all times", "at all times", "Para 4.9.1.1.10");//D
        this.addQuestion(q111);
        Question q112 = new Question("Ensure the dormitory sleeping configuration is a _______ configuration.", "head-to-toe", "head-to-head", "toe-to-toe", "random", "head-to-toe", "Para 4.9.1.2.3");//A
        this.addQuestion(q112);
        Question q113 = new Question("Ensure cleaning crews clean all dormitory and BEAST floor surfaces _________ with anti-viral germicidal detergents.", "weekly", "monthly", "daily", "once", "daily", "Para 4.9.1.2.4");//C
        this.addQuestion(q113);
        Question q114 = new Question("When using BLEACH to clean, the dilution formula is:  ", "1 cup of bleach to one gallon of water.", "1/2 cup of bleach to one gallon of water", "1/4 cup of bleach to one gallon of water.", "3/4 cup of bleach to one gallon of water.", "1/4 cup of bleach to one gallon of water.", "Para. 4.9.1.2.5");//C
        this.addQuestion(q114);
        Question q115 = new Question("Public Health/IDMTs perform ________ dormitory hygiene inspections", "daily", "weekly", "monthly", "random", "random", "Para. 4.9.2");//D
        this.addQuestion(q115);
        Question q116 = new Question("Which of the following is NOT a guideline for initiating MTI Tools:", "Flight may perform as a show of teamwork", "Flight may exercise for the majority", "Flight will not exercise for the deficiencies of a few individuals", "Flight will perform for student leaders", "Flight will perform for student leaders", "Para. 4.10.3");//D
        this.addQuestion(q116);
        Question q117 = new Question("DO NOT administer MTI Tools: ", "Prior to first PT Eval / During PT", "Trainees in the 0 WOT", "Trainees in various states of undress", "All the above", "All the above", "Para. 4.10.4");//D
        this.addQuestion(q117);
        Question q118 = new Question("DO NOT administer MTI Tools: ", "In the dayroom", "To the point of injury or illness", "In the dining facility or within 1 hour of meals", "All the above", "All the above", "Para. 4.10.4");//D
        this.addQuestion(q118);
        Question q119 = new Question("Which of the following is NOT a prohibited location for MTI Tools?", "Under overhangs at BLDG 5616 and BLDG 5725", "Latrines, classrooms, dayrooms, clinics or other medical facilities", "Inside BLDG 5616 and BLDG 5725", "In the vicinity of the chapel or mini malls", "Under overhangs at BLDG 5616 and BLDG 5725", "Para. 4.10.6");//A
        this.addQuestion(q119);
        Question q120 = new Question("(Exercise Challenge) Trainees in the 1 WOT may perform how many sets of MTI Tools?", "1 Set", "2 Sets", "None", "3 Sets", "1 Set", "Para. Table 4.1(a)");//A
        this.addQuestion(q120);
        Question q121 = new Question("(Exercise Challenge) Trainees in the 2 WOT (and above) may perform how many sets of MTI Tools?", "1 Set", "2 Sets", "None", "3 Sets", "2 Sets", "Para. Table 4.1(b)");//B
        this.addQuestion(q121);
        Question q122 = new Question("(Exercise Challenge) Trainees will NOT perform more than _______ sets?", "5 per day", "5 per Instructor", "10 per day", "10 per Instructor", "5 per day", "Para. Table 4.1");//A
        this.addQuestion(q122);
        Question q123 = new Question("Individual trainees may be moved to another dormitory on weekends or holidays only when approval has been issued by ______________.", "Dorm Chief", "Team Member", "Supervisory Personnel", "Team Chief", "Supervisory Personnel", "Para. Table 4.1");//C
        this.addQuestion(q123);
        Question q124 = new Question("Within__ hours of arrival, trainees must be provided an initial phone", "24", "48", "72", "96", "72", "Para. 4.11.2");//C
        this.addQuestion(q124);
        Question q125 = new Question("The initial phone call must be a minimum of ____ minutes.", "7", "10", "2", "5", "5", "Para. 4.11.2");//D
        this.addQuestion(q125);
        Question q126 = new Question("All trainee phone calls are conducted between _________ with the exception of trainees that require phone calls outside the continental United States.", "0800-2100", "1800-2100", "0800-1100", "2100-2400", "0800-2100", "Para. 4.11.3");//A
        this.addQuestion(q126);
        Question q127 = new Question("Trainees are provided a phone session in the fourth and seventh week of training (minimum of ___ minutes).", "5", "10", "15", "20", "15", "Para. 4.11.4");//C
        this.addQuestion(q127);
        Question q128 = new Question("The MTI may authorize longer phone periods and additional privileges based on ________ performance.", "individual", "element leader", "dorm chief", "flight", "flight", "Para. 4.11.4");//D
        this.addQuestion(q128);
        Question q129 = new Question("Who is NOT authorized to control cell phone sessions: ", "IS", "Superintendent", "Director of Operations", "Interim IS", "Interim IS", "Para. 4.11.4 ");//D
        this.addQuestion(q129);
        Question q130 = new Question("Who is authorized to conduct the 'Cell Phone Policy Briefing'?", "Director of Operations", "Interim IS", "IS/FC", "Squadron Superintendent", "IS/FC", "Para. 4.11.6 ");//C
        this.addQuestion(q130);
        Question q131 = new Question("Where should trainees annotate cell phone damages?", "341", "Luggage Tag", "No documentation required", "Cell Phone Briefing Roster", "Cell Phone Briefing Roster", "Para. 4.11.7.3");//D
        this.addQuestion(q131);
        Question q132 = new Question("(Cell Phone Storage) Place phone in properly marked tray according to _______.", "roster number", "dorm number", "social security number", "bed number", "bed number", "Para. 4.11.8");//D
        this.addQuestion(q132);
        Question q133 = new Question("Keys for cell phone storage containers are controlled by the squadron CQ, annotated by ___________.", "floor", "dorm number", "flight number", "section", "dorm number", "Para. 4.11.8.1");//B
        this.addQuestion(q133);
        Question q134 = new Question("MTIs must turn in a corrected flight roster to their servicing postal service center NLT the Monday of the _ WOT.", "1", "2", "3", "4", "1", "Para. 4.12.5");//A
        this.addQuestion(q134);
        Question q135 = new Question("In order to pick-up mail at the PSC, the MTI must have a current DD Form ____.", "479", "490", "285", "341", "285", "Para. 4.12.6");//C
        this.addQuestion(q135);
        Question q136 = new Question("What day are MTI's NOT required to distribute mail to trainees?", "Details", "PT Evals", "Duty Flight", "CBRNE", "Details", "Para. 4.12.10");//D
        this.addQuestion(q136);
        Question q137 = new Question("When are trainees authorized to write and mail letters?", "Upon completion of duty flight", "During any available downtime", "Anytime", "Upon completion of duties and details", "Upon completion of duties and details", "Para. 4.12.15");//D
        this.addQuestion(q137);
        Question q138 = new Question("Turn in gaining base roster to the servicing PSC NLT Friday of the _ WOT.", "5", "6", "7", "8", "8", "Para. 4.12.12");//D
        this.addQuestion(q138);
        Question q139 = new Question("MTIs print one letter minimum per trainee, but no more than ________.", "two", "three", "four", "five", "three", "Para. 4.13.2");//B
        this.addQuestion(q139);
        Question q140 = new Question("MTIs hand-carry completed letters/envelopes to the Reception Center, NLT 1200, Monday of the __ WOT.", "4", "3", "2", "1", "1", "Para. 4.13.4 ");//D
        this.addQuestion(q140);
        Question q141 = new Question("When are MTI's authorized to conduct 'Closed Door' counseling sessions?", "When the conversation is private in nature", "When the conversation is about a flight member", "If the trainee requests it", "It is never authorized", "It is never authorized", "Para. 4.15.1.1");//D
        this.addQuestion(q141);
        Question q142 = new Question("If a counseling session of a personal or delicate nature is required, the trainee is referred to _____________.", "Supervisory Personnel", "Chaplin", "Team Chief", "Family Member", "Supervisory Personnel", "Para. 4.15.1.3");//A
        this.addQuestion(q142);
        Question q143 = new Question("______ supervisory personnel conduct closed door counseling sessions with two instructors present if HIPAA information is discussed.", "324TRS", "323TRS", "322TRS", "321TRS", "324TRS", "Para. ");//A
        this.addQuestion(q143);
        Question q144 = new Question("MTIs will provide trainees a mandatory __ minute Initial Patio Break.", "15", "60", "30", "45", "45", "Para. 4.17.1");//D
        this.addQuestion(q144);
        Question q145 = new Question("MTIs will provide trainees a mandatory __ hour Initial Base Liberty.", "2", "3", "4", "5", "2", "Para. 4.17.1");//A
        this.addQuestion(q145);
        //Chapter 5
        Question q146 = new Question("(M16 Trainer Weapons) Each squadron will conduct an accountability check NET 1600 and BLT 2000; who is responsible for reporting their accountability to the CQ?", "Entry Controller", "Weapons Monitor", "Dorm Chief", "Flight Instructor", "Flight Instructor", "Para. 5.2.4.1");//D
        this.addQuestion(q146);
        Question q147 = new Question("(RH&T M16 Daily Storage) When stored in the carrying case under the bed, which of the following is the correct method of display?", "Muzzle of the rifle is towards the center isle", "Muzzle of the rifle is towards the wall locker", "Carrying handle will be towards the non-inspection side", "pistol grip towards the non-inspection side", "Muzzle of the rifle is towards the center isle", "Para. 5.2.5.2.1");//A
        this.addQuestion(q147);
        Question q148 = new Question("(Clearing Barrel Area) A clear zone must be established around each Clearing Barrel:  ____ feet on each side and _____ feet in the front and outlined in _______.", "3 / 6 / Yellow", "3 / 6 / Red", "6 / 3 / Yellow", "6 / 3 / Red", "3 / 6 / Red", "Para. 5.3.1");//B
        this.addQuestion(q148);
        Question q149 = new Question("Only two individuals are authorized inside the clearing zone when a trainee is clearing the M-16 trainer weapon: trainee clearing the weapon and _______.", "Dorm Chief", "MTI", "Weapon Monitor", "Wingman", "MTI", "Para. 5.3.3");//B
        this.addQuestion(q149);
        Question q150 = new Question("When a flight is clearing their M-16 trainer weapons, trainees / instructors will not march between the flight and the clearing zone, this is a ____________.", "Bad Conduct", "General Infraction", "Safety Violation", "Unprofessional Conduct", "Safety Violation", "Para. 5.3.2");//C
        this.addQuestion(q150);
        Question q151 = new Question("All personnel approach the clearing barrel with their M-16 trainer weapon at ______.", "sling-arms", "any position", "low-ready", "port-arms", "port-arms", "Para. 5.3.4.2");//D
        this.addQuestion(q151);
        Question q152 = new Question("M-16 Trainer weapon roster must remain in the flight clipboard until after the flight ________.", "turns in weapons", "returns from BEAST", "ships to Tech Training", "ships to BEAST", "turns in weapons", "Para. 5.4.1");//A
        this.addQuestion(q152);
        Question q153 = new Question("The first step of Clearing Procedures for the M16 Trainer Weapon is ______?", "Lock bolt to the rear", "Remove magazine", "Verify weapon on safe", "Insert muzzle into clearing barrel", "Insert muzzle into clearing barrel", "Para. 5.4.5");//D
        this.addQuestion(q153);
        Question q154 = new Question("The last step of Clearing Procedures for the M16 Trainer Weapon is _______?", "Sling trainer weapon", "Load magazine", "Ensure weapon is OFF safe", "Verify serial number", "Sling trainer weapon", "Para. ");//A
        this.addQuestion(q154);
        Question q155 = new Question("Muzzle caps are provided for each trainer weapon and must be attached to the muzzle during _________", "FEST I", "FEST II", "Inclement Weather", "All the above", "All the above", "Para. 5.4.6");//D
        this.addQuestion(q155);
        Question q156 = new Question("Violations of any type (relating to M-16 trainer weapons) will result in an __________.", "Derogatory Comment", "Immediate Recycle", "Unsatisfactory CVR", "Satisfactory CVR", "Unsatisfactory CVR", "Para. 5.5.3");//C
        this.addQuestion(q156);
        Question q157 = new Question("Any trainee caught using the M-16 trainer weapon inappropriately will be immediately referred to _____________.", "Dorm Chief", "MTI Team", "CQ", "supervisory personnel", "supervisory personnel", "Para. 5.5.5");//D
        this.addQuestion(q157);
        Question q158 = new Question("If rain occurs, trainee will carry their M-16 trainer weapon at sling arms with the muzzle pointed towards the ___________.", "ground", "sky", "either", "neither", "ground", "Para. 5.5.17");//A
        this.addQuestion(q158);
        Question q159 = new Question("Who is responsible for conducting nightly accountability check for all personnel and M-16 trainer weapons while at BEAST?", "Weapons Monitor", "BEAST Monitor", "Element Leader", "Dorm Chief", "Dorm Chief", "Para. 5.6.4");//D
        this.addQuestion(q159);
        //Chapter 6
        Question q160 = new Question("The FIRST time a trainee fails the EOC, who is responsible for documenting the 'U' grade on the BMT Form 105?", "I.S.", "Flight MTI", "Not required", "WSMS", "WSMS", "Para. 6.3.1");//D
        this.addQuestion(q160);
        Question q161 = new Question("The SECOND time a trainee fails the EOC, they may be allowed to test a Third time if approved by _________.", "Flight Commander", "Instructor Supervisor", "Squadron Superintendent", "Director of Operations", "Director of Operations", "Para. 6.3.2");//D
        this.addQuestion(q161);
        Question q162 = new Question("Who is the approval authority to allow a trainee a 4th attempt to pass the EOC?", "737TRG/CCF", "737TRG/CCV", "737TRG/CC", "737TRG/CCC", "737TRG/CC", "Para. 6.3.3");//B
        this.addQuestion(q162);
        Question q163 = new Question("How many days are required between the appraisal and progress checks?", "1", "2", "3", "4", "2", "Para. 6.5.2.2.2");//B
        this.addQuestion(q163);
        Question q164 = new Question("If a trainee fails a third evaluation on a PC, who provides the SQ/CC with a recommendation for recycle/separation?", "MTI", "F.C.", "I.S.", "D.O.", "D.O.", "Para. 6.5.2.4.1");//D
        this.addQuestion(q164);
        Question q165 = new Question("If a trainee fails a MOS inspection, where should it be documented?", "BMT 205", "BMT128A", "BMT105A", "Both B and C", "Both B and C", "Para. 6.4.3.");//D
        this.addQuestion(q165);
        Question q166 = new Question("Which of the following is NOT a BMT graduation Requirement?", "Attend LOAC", "Attend CoC", "Attend FEST", "HF/WF Control", "HF/WF Control", "Table. 6.2");//D
        this.addQuestion(q166);
        Question q167 = new Question("Who is the designated waiver authority for BEAST?", "737 TRG CC or CD", "737 TRG CCV", "737 TRG CCC", "737 TRG CCF", "737 TRG CC or CD", "Para. 6.6.1");//A
        this.addQuestion(q167);
        Question q168 = new Question("Trainees who are shadowing a 7 WOT flight while their flight is at BEAST will wear what uniform?", "7WOT UOD", "ABU's only", "Whatever the flight is wearing", "Blues only", "ABU's only", "Para. 6.6.1 Exception");//B
        this.addQuestion(q168);
        //Chapter 7
        Question q169 = new Question("What is the correct filing order for flight records?", "Active, Reserve, Guard", "Active, Guard, Reserve", "Reserve, Active, Guard", "Guard, Active, Reserve", "Active, Reserve, Guard", "Para. 7.1.2");//A
        this.addQuestion(q169);
        Question q170 = new Question("Before a trainee is tranferred out of the squadron, who must review all paperwork?", "Both C and D", "Squadron Commander", "Director of Operations", "Squadron Superintendent", "Both C and D", "Para. 7.2.1");//A
        this.addQuestion(q170);
        Question q171 = new Question("If a trainee is admitted to the hospital, when must the trainees records be turned into supervisory personnel during the next duty day?", "0800", "1000", "1200", "1400", "0800", "Para. 7.2.2");//A
        this.addQuestion(q171);
        Question q172 = new Question("If a trainee is transferred to MEDHOLD in BTMS, but the trainee is not physically reporting to MEDHOLD that day, when must their records be dropped off at MEDHOLD?", "1200", "1400", "1700", "1900", "1700", "Para. 7.2.4");//C
        this.addQuestion(q172);
        Question q173 = new Question("When a trainee is awarded an Unsatisfactory Core Value Rating, whatelse must accompany it?", "Referral to the I.S.", "A comment in BTMS", "A Reval within 24 hours", "RLA Evaluation", "A comment in BTMS", "Para. 7.3.2.2");//D
        this.addQuestion(q173);
        Question q174 = new Question("Where is the Initial PT and Final PT BMT Information located?", "AFI 36-2905", "737TRGOI 36-2905", "737TRG 36-3", "737TRG 36-2", "737TRGOI 36-2905", "Para. 7.3.3.1");//B
        this.addQuestion(q174);
        Question q175 = new Question("Evaluations must be entered into BTMS NLT ________.", "End of the same duty day", "12 Hours from Eval", "24 Hours from Eval", "The end of the next duty day", "The end of the next duty day", "Para. ");//D
        this.addQuestion(q175);
        Question q176 = new Question("Re-evaluation must be conducted within _ training days of initial evaluation.", "1", "2", "3", "4", "2", "Para. 7.3.4.1.2");//B
        this.addQuestion(q176);
        Question q177 = new Question("If a trainee fails a re-evaluation, who should the trainee be referred to?", "Team Chief", "I.S./F.C.", "DO", "CC", "I.S./F.C.", "Para. 7.3.4.1.2");//D
        this.addQuestion(q177);
        Question q178 = new Question("Student leaders must be appointed NLT __________.", "Start of 2 WOT", "End of 2 WOT", "End of 1 WOT", "Start of 3 WOT", "End of 2 WOT", "Para. 7.3.5.1");//B
        this.addQuestion(q178);
        Question q179 = new Question("How many key positions can a trainee be assigned to at one time?", "1", "2", "3", "4", "1", "Para. 7.3.5.2");//A
        this.addQuestion(q179);
        Question q180 = new Question("Which type of waiver is NOT required to be entered into BTMS Waiver section?", "Shaving", "Drill", "PT", "Prolonged Standing", "Shaving", "Para. 7.3.7.1");//A
        this.addQuestion(q180);
        Question q181 = new Question("To be effective, counseling must be specific, constructive and timely (typically within ______ hours).", "12", "24", "48", "36", "48", "Para. 7.4.4.2");//C
        this.addQuestion(q181);
        Question q182 = new Question("Which of the following are the correct 4 parts to a required comment:", "Deficiency, Reason for Deficiency, Response, Disposition", "Deficiency, Response from trainee, Resolution, Disposition", "UCMJ relation, Reason for Deficiency, Resolution, Disposition", "Deficiency, Reason for Deficiency, Resolution, Disposition", "Deficiency, Reason for Deficiency, Resolution, Disposition", "Para. ");//D
        this.addQuestion(q182);
        Question q183 = new Question("If referred to supervisory personnel, trainees should be counseled NLT ________.", "2 hours from incident", "week of training", "2 duty days", "the next duty day", "the next duty day", "Para. 7.4.6.");//D
        this.addQuestion(q183);
        Question q184 = new Question("Shipping records must be filed within _ days of shipping.", "1", "2", "3", "4", "3", "Para. 7.6.3");//C
        this.addQuestion(q184);
        //Chapter 8
        Question q185 = new Question("100% of trainees must accomplish Mandatory Drug Testing within __ hours of initial arrival to BMT.", "24", "48", "72", "96", "72", "Para. 8.1");//C
        this.addQuestion(q185);
        Question q186 = new Question("MTI will wear _______ when taking a flight to Drug Testing.", "Duty Uniform", "MTI PT Gear", "Blues", "AF PT Gear", "Duty Uniform", "Para. 8.1.2");//A
        this.addQuestion(q186);
        Question q187 = new Question("What two items must a trainee have with them prior to being allowed to provide a urine sample for drug testing?", "A picture and SSN card only", "Only a SSN card is required", "Photo ID and SSN proof", "Photo ID and Bank Info", "Photo ID and SSN proof", "Para. 8.1.3.1");//C
        this.addQuestion(q187);
        Question q188 = new Question("If a trainee does not have a Photo or SSN proof they should be sent to _______", "737TRSS Processing Flight", "MED/DENTAL", "Career Guidance", "Orders Pickup", "737TRSS Processing Flight", "Para. 8.1.3.2");//A
        this.addQuestion(q188);
        Question q189 = new Question("Trainees unable to provide a sample on Wednesday evening should report back to the testing site on Thursday at ___________.", "1730", "2030", "1930", "1830", "1830", "Para. 8.1.5.");//D
        this.addQuestion(q189);
        Question q190 = new Question("Trainees unable to provide a sample on Thursday evening should report back to the testing site on Friday at _____________.", "1300", "1400", "1500", "1600", "1300", "Para. 8.1.6");//A
        this.addQuestion(q190);
        Question q191 = new Question("Trainees unable to provide a sample on Friday evening should report back to the testing site on Monday at ___________.", "0600", "0700", "0800", "0900", "0800", "Para. 8.1.7");//C
        this.addQuestion(q191);
        Question q192 = new Question("Trainees that are seen at the UCC or SAMMC must see a provider at REID Clinic NLT __________.", "First duty day after returning", "Within 2 duty days", "Only if needed", "When (if) waiver expires", "First duty day after returning", "Para. 8.2.2");//A
        this.addQuestion(q192);
        Question q193 = new Question("Which of the following symptoms constitutes an Emergency Health Care Situation: ", "Stomach Pain", "Vomiting", "Diarrhea", "Very Confused", "Very Confused", "Table 8.1");//D
        this.addQuestion(q193);
        Question q194 = new Question("(Fever Flight) Ill trainees may eat in the dining facility during normal hours, but must sit at least _ feet from non-ill trainees.", "1", "2", "3", "4", "3", "Para. 8.7.4");//C
        this.addQuestion(q194);
        Question q195 = new Question("If an MTI identifies a trainee as having a potential mental/behavioral problem, what is required on White Bond paper when the trainee is sent to a medical facility?", "BMT105A", "4 AFQT scores and a statement", "Witness statements", "AFSC", "4 AFQT scores and a statement", "Para. 8.8.2");//B
        this.addQuestion(q195);
        Question q196 = new Question("If a trainee requests a mental health evaluation, what is NOT required?", "Boxer Rights", "2 Escorts", "I.S. Counseling", "Supporting Documentation", "Boxer Rights", "Para. 8.8.13");//D
        this.addQuestion(q196);
        Question q197 = new Question("Which medication may trainees continue to consume that was issued from a civilian provider prior to them arriving at BMT?", "Any Medication", "Dietary Supplements", "Pain Killers", "Birth Control", "Birth Control", "Para. 8.10.1");//D
        this.addQuestion(q197);
        //Chapter 9
        Question q198 = new Question("Who is the approval authority for recycle actions longer than 2 weeks?", "737TRG/CC", "TRS/CC", "737TRG/CCF", "TRS/CCF", "737TRG/CC", "Para. 9.1.3");//B
        this.addQuestion(q198);
        Question q199 = new Question("Trainees recycled out of squadron must out-process the losing squadron by ______ and in-process the gaining squadron by _________.", "1300 / 1700", "1500 / 1800", "0900 / 1300", "1000 / 1200", "1300 / 1700", "Para. 9.1.6.2");//A
        this.addQuestion(q199);
        Question q200 = new Question("Trainees admitted to the hospital for medical reasons (non-mental health), a 3-day bag is delivered within _______ hours.", "12", "24", "26", "48", "24", "Para. 9.2.1");//B
        this.addQuestion(q200);
        Question q201 = new Question("If a trainee is admitted for longer than ___ hours, their property must be inventoried and kept in PT/Supply.", "24", "48", "72", "96", "72", "Para. 9.2.1");//C
        this.addQuestion(q201);
        Question q202 = new Question("Trainees granted convalescence leave must depart on leave and return from leave to which squadron?", "Assigned Squadron", "324TRS", "Old Flight Squadron", "New Flight Squadron", "324TRS", "Para. 9.3.1.1.");//B
        this.addQuestion(q202);
        Question q203 = new Question("Ensure that trainees receive one set of _______ to wear when traveling on leave.", "Civilian clothes", "ABU's", "PT Gear", "blues", "blues", "Para. 9.3.1.4");//D
        this.addQuestion(q203);
        Question q204 = new Question("Who is responsible for providing an area to store and protect trainee clothing and personal items, when they are absent (on leave) from the squadron?  ", "CC", "PT/Supply", "MTI", "IS", "CC", "Para. 9.3.1.5 NOTE");//A
        this.addQuestion(q204);
        Question q205 = new Question("If a trainee is determined to be AWOL, when must their property be inventoried and secured?", "2 days", "3 days", "Same day", "Next duty day", "Next duty day", "Para. 9.4.1");//D
        this.addQuestion(q205);
        Question q206 = new Question("After how many days is a trainees belongings considered abandoned and must be turned in? (AWOL Trainee)", "90 days", "120 days", "150 days", "180 days", "120 days", "Para. 9.4.3");//D
        this.addQuestion(q206);
        Question q207 = new Question("Which of the following are NOT grounds for entry-level discharge:", "Difficulty adapting to military life", "Pregnancy", "Disciplinary Infractions", "Lacking self-discipline or respect for authority", "Difficulty adapting to military life", "Para. 9.5.1");//A
        this.addQuestion(q207);
        Question q208 = new Question("What is the maximum holding time for a trainee in th 802 SFS holding cell?", "1 hour", "2 hours", "3 hours", "4 hours", "3 hours", "Para. 9.6.5");//C
        this.addQuestion(q208);
        Question q209 = new Question("If a trainee purchases electronics during Graduation Weekend, what should they do with them?", "Ship them to their Technical Training Base", "Bring them to the Dorm", "Bring them to CQ", "Ship them home", "Ship them to their Technical Training Base", "Para. 9.12.3");//A
        this.addQuestion(q209);
        //Chapter 10
        Question q210 = new Question("(737TRSS) Which armband color represents Separations Flight?", "Red", "Green", "Blue", "Orange", "Orange", "Para. 10.2.3.1");//D
        this.addQuestion(q210);
        Question q211 = new Question("(737TRSS) Which armband color represents Medical Hold Flight?", "Red", "Green", "Blue", "Orange", "Blue", "Para. 10.2.3.2");//C
        this.addQuestion(q211);
        Question q212 = new Question("(737TRSS) Which armband color represents Get Fit Flight?", "Red", "Green", "Blue", "Orange", "Green", "Para. 10.2.3.3");//B
        this.addQuestion(q212);
        Question q213 = new Question("How often are trainees assigned to the Get Fit Program evaluated IAW PT Progress Check?", "Daily", "Bi-Weekly", "Weekly", "Every 48 Hours", "Weekly", "Para. 10.3.1");//C
        this.addQuestion(q213);
        Question q214 = new Question("Trainees not meeting fitness standards after __ days in the Get Fit program may be considered for discharge.", "30", "60", "90", "120", "30", "Para. 10.3.6");//A
        this.addQuestion(q214);
        //Chapter 11
        Question q215 = new Question("If the risk outweighs the benefit, MTI's should use the groups ________ policy.", "Stop It", "Knock It Off", "Get Help", "Re-Think It", "Knock It Off", "Para. 11.1.2.3");//B
        this.addQuestion(q215);
        Question q216 = new Question("What should an MTI do during a Thunderstorm Watch?", "No actions required", "Be prepared to seek the nearest shelter", "Shelter In Place Immediately", "Transit Flight without Guidon", "Be prepared to seek the nearest shelter", "Para. 11.3.3.1");//B
        this.addQuestion(q216);
        Question q217 = new Question("What should an MTI do during Lightning Within 5 Miles?", "Secure Guidon and M16 trainer weapons", "Transit Normally", "Shelter In Place", "Double Time to squadron", "Secure Guidon and M16 trainer weapons", "Para. 11.3.4.1");//A
        this.addQuestion(q217);
        Question q218 = new Question("Hyponatremia (water intoxication) can be caused by ingestion of large amounts of water (greater than __ canteens per hour).", "1.5", "2.5", "2", "1", "1.5", "Para. 11.6.1");//A
        this.addQuestion(q218);
        //Chapter 12
        Question q219 = new Question("Trainees may only miss class for __________ appointments.", "medical", "processing", "Both A and B", "Neither A and B", "Both A and B", "Para. 12.1.1");//D
        this.addQuestion(q219);
        Question q220 = new Question("Which of the following is an example of a military training that may take priority over religious activities.", "Drill Practice", "Dormitory Details", "KP Detail", "BEAST Packing", "KP Detail", "Para. 12.2.1.2");//C
        this.addQuestion(q220);
        Question q221 = new Question("Appoint chapel guides NLT the _________ briefing.", "Chapel Orientation", "First Week", "BMT Arrival", "Entry Controller", "Chapel Orientation", "Para. 12.2.2.2");//A
        this.addQuestion(q221);
        Question q222 = new Question("Chapel guides must be at the chapel NLT _____ on Sundays.", "0730", "0800", "0700", "0630", "0630", "Para. 12.2.2.6");//D
        this.addQuestion(q222);
        /*Question q223 = new Question("", "", "", "", "", "", "Para. ");//D
        this.addQuestion(q223);
        Question q224 = new Question("", "", "", "", "", "", "Para. ");//D
        this.addQuestion(q224);
        Question q225 = new Question("", "", "", "", "", "", "Para. ");//D
        this.addQuestion(q225);
        Question q226 = new Question("", "", "", "", "", "", "Para. ");//D
        this.addQuestion(q226);
        Question q227 = new Question("", "", "", "", "", "", "Para. ");//D
        this.addQuestion(q227);
        */
    }

    /**
     * Upgrades database from older version to new version by dropping all
     * tables and recreating the database
     */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		// Create tables again
		onCreate(db);
	}
	// Adding new question
    void addQuestion(Question quest) {
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQUESTION()); 
		values.put(KEY_ANSWER, quest.getANSWER());
		values.put(KEY_OPTA, quest.getOPTA());
		values.put(KEY_OPTB, quest.getOPTB());
		values.put(KEY_OPTC, quest.getOPTC());
		values.put(KEY_OPTD, quest.getOPTD());
		values.put(KEY_REFERENCE, quest.getREFERENCE());
		// Inserting Row
		dbase.insert(TABLE_NAME, null, values);
	}
	
	/**
	 * Executes SQL query to retrieve 20 random rows from database and loads in arrayList for use with XML file
	 */

	public List<Question> getAllQuestions() {
		List<Question> quesList = new ArrayList<Question>();
		@SuppressWarnings("MismatchedQueryAndUpdateOfCollection") List<Question> ReviewList = new ArrayList<Question>();
		// Select All Query
		String selectQuery2 = "SELECT DISTINCT * FROM " + TABLE_NAME + " ORDER BY RANDOM() LIMIT 20";
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery2, null);
		// looping through all rows and adding to list
		
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setQUESTION(cursor.getString(1));
				quest.setANSWER(cursor.getString(2));
				quest.setOPTA(cursor.getString(3));
				quest.setOPTB(cursor.getString(4));
				quest.setOPTC(cursor.getString(5));
				quest.setOPTD(cursor.getString(6));
				quest.setREFERENCE(cursor.getString(7));
				quesList.add(quest);
				//Load List for Review
				ReviewList.add(quest);
			} while (cursor.moveToNext());
		}
		return quesList;
	}

    public List<Question> getChapterOneQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection") List<Question> ReviewList = new ArrayList<Question>();
        // Select All Query
        //String selectQuery2 = "SELECT DISTINCT * FROM " + TABLE_NAME + " ORDER BY RANDOM() LIMIT 20";
        String selectQuery3 = "SELECT DISTINCT * FROM " + TABLE_NAME + " LIMIT 4"; //Chapter 1 is questions 1-4
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery3, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setOPTD(cursor.getString(6));
                quest.setREFERENCE(cursor.getString(7));
                quesList.add(quest);
                //Load List for Review
                ReviewList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }

    public List<Question> getChapterTwoQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection") List<Question> ReviewList = new ArrayList<Question>();
        String selectQuery4 = "SELECT DISTINCT * FROM " + TABLE_NAME + " LIMIT 20 OFFSET 4"; //Chapter 2 is questions 5-43
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery4, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setOPTD(cursor.getString(6));
                quest.setREFERENCE(cursor.getString(7));
                quesList.add(quest);
                //Load List for Review
                ReviewList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }

    public List<Question> getChapterThreeQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection") List<Question> ReviewList = new ArrayList<Question>();
        String selectQuery5 = "SELECT DISTINCT * FROM " + TABLE_NAME + " LIMIT 20 OFFSET 43"; //Chapter 2 is questions 44-80
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery5, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setOPTD(cursor.getString(6));
                quest.setREFERENCE(cursor.getString(7));
                quesList.add(quest);
                //Load List for Review
                ReviewList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }

    public List<Question> getChapterFourQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection") List<Question> ReviewList = new ArrayList<Question>();
        String selectQuery6 = "SELECT DISTINCT * FROM " + TABLE_NAME + " LIMIT 20 OFFSET 80"; //Chapter 4 is questions 81-145
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery6, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setOPTD(cursor.getString(6));
                quest.setREFERENCE(cursor.getString(7));
                quesList.add(quest);
                //Load List for Review
                ReviewList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }

    public List<Question> getChapterFiveQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection") List<Question> ReviewList = new ArrayList<Question>();
        String selectQuery7 = "SELECT DISTINCT * FROM " + TABLE_NAME + " LIMIT 20 OFFSET 145"; //Chapter 5 is questions 146-159
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery7, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setOPTD(cursor.getString(6));
                quest.setREFERENCE(cursor.getString(7));
                quesList.add(quest);
                //Load List for Review
                ReviewList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }

    public List<Question> getChapterSixQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection") List<Question> ReviewList = new ArrayList<Question>();
        String selectQuery6 = "SELECT DISTINCT * FROM " + TABLE_NAME + " LIMIT 8 OFFSET 159"; //Chapter 6 is questions 160-168
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery6, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setOPTD(cursor.getString(6));
                quest.setREFERENCE(cursor.getString(7));
                quesList.add(quest);
                //Load List for Review
                ReviewList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }

    public List<Question> getChapterSevenQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection") List<Question> ReviewList = new ArrayList<Question>();
        String selectQuery7 = "SELECT DISTINCT * FROM " + TABLE_NAME + " LIMIT 15 OFFSET 168"; //Chapter 7 is questions 169-184
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery7, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setOPTD(cursor.getString(6));
                quest.setREFERENCE(cursor.getString(7));
                quesList.add(quest);
                //Load List for Review
                ReviewList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }

    public List<Question> getChapterEightQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection") List<Question> ReviewList = new ArrayList<Question>();
        String selectQuery8 = "SELECT DISTINCT * FROM " + TABLE_NAME + " LIMIT 12 OFFSET 184"; //Chapter 8 is questions 185-197
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery8, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setOPTD(cursor.getString(6));
                quest.setREFERENCE(cursor.getString(7));
                quesList.add(quest);
                //Load List for Review
                ReviewList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }

    public List<Question> getChapterNineQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection") List<Question> ReviewList = new ArrayList<Question>();
        String selectQuery9 = "SELECT DISTINCT * FROM " + TABLE_NAME + " LIMIT 11 OFFSET 197"; //Chapter 9 is questions 198-209
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery9, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setOPTD(cursor.getString(6));
                quest.setREFERENCE(cursor.getString(7));
                quesList.add(quest);
                //Load List for Review
                ReviewList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }

    public List<Question> getChapterTenQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection") List<Question> ReviewList = new ArrayList<Question>();
        String selectQuery10 = "SELECT DISTINCT * FROM " + TABLE_NAME + " LIMIT 4 OFFSET 209"; //Chapter 10 is questions 210-214
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery10, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setOPTD(cursor.getString(6));
                quest.setREFERENCE(cursor.getString(7));
                quesList.add(quest);
                //Load List for Review
                ReviewList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }

    public List<Question> getChapterElevenQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection") List<Question> ReviewList = new ArrayList<Question>();
        String selectQuery11 = "SELECT DISTINCT * FROM " + TABLE_NAME + " LIMIT 4 OFFSET 214"; //Chapter 11 is questions 215-218
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery11, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setOPTD(cursor.getString(6));
                quest.setREFERENCE(cursor.getString(7));
                quesList.add(quest);
                //Load List for Review
                ReviewList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }
}
