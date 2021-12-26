package geneticAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

import model.*;

public class Data 
{
    private ArrayList<Classroom> classrooms;	
	public ArrayList<Professor> professors;
	private ArrayList<StudentsGroup> studentsGroups;	
	public ArrayList<Subject> subjects;
    private Department department;	
	private ArrayList<Program> programs;	
	private ArrayList<LectureTime> lectureTimes;	
	private int numberOfClasses = 0;	
	 
	public Data() {
		initialize();
	}
	
	private Data initialize() 
    {
        department = new Department(2021, "Matematike");

		Program shkencaKomputerike =      new Program("shkencaKomputerike", department);
        Program matematikeFinanciare =    new Program("matematikeFinanciare", department);
        Program matematikeEPergjithshme = new Program("matematikeEPergjithshme", department);
        programs = new ArrayList<Program>(Arrays.asList(shkencaKomputerike, matematikeFinanciare, matematikeEPergjithshme));
    

		Time ts1 = new Time(8, 0);
        Time te1 = new Time(9, 30);

        Time ts2 = new Time(8, 15);
        Time te2 = new Time(9, 45);

        Time ts3 = new Time(8, 30);
        Time te3 = new Time(10, 0);

		Time ts41 = new Time(8, 45);
        Time te4 = new Time(10, 15);

        Time ts4 = new Time(9, 0);
        Time te5 = new Time(10, 30);

        Time ts5 = new Time(9, 15);
        Time te6 = new Time(10, 45);

        Time ts6 = new Time(9, 30);
        Time te7= new Time(11, 0);

        Time ts7 = new Time(9, 45);
        Time te8 = new Time(11, 15);

        Time ts8 = new Time(10, 0);
        Time te9 = new Time(11, 30);

        Time ts9 = new Time(10, 15);
        Time te10 = new Time(11, 45);

        Time ts10 = new Time(10, 30);
        Time te11 = new Time(12, 0);

        Time ts11 = new Time(10, 45);
        Time te12 = new Time(12, 15);

        Time ts12 = new Time(11, 0);
        Time te13 = new Time(12, 30);

        Time ts13 = new Time(11, 15);
        Time te14 = new Time(12, 45);

        Time ts14 = new Time(11, 30);
        Time te15 = new Time(13, 0);

        Time ts15 = new Time(11, 45);
        Time te16 = new Time(13, 15);

        Time ts16 = new Time(12, 0);
        Time te17 = new Time(13, 30);

        Time ts17 = new Time(12, 15);
        Time te18 = new Time(13, 45);

        Time ts18 = new Time(12, 30);
        Time te19 = new Time(14, 0);

        Time ts19 = new Time(12, 45);
        Time te20 = new Time(14, 15);

        Time ts20 = new Time(13, 0);
        Time te21 = new Time(14, 30);

        Time ts21 = new Time(13, 15);
        Time te22 = new Time(14, 45);

        Time ts22 = new Time(13, 30);
        Time te23 = new Time(15, 0);

        Time ts23 = new Time(13, 45);
        Time te24 = new Time(15, 15);

        Time ts24 = new Time(14, 0);
        Time te25 = new Time(15, 30);

        Time ts25 = new Time(14, 15);
        Time te26 = new Time(15, 45);

        Time ts26 = new Time(14, 30);
        Time te27 = new Time(16, 0);

        Time ts27 = new Time(14, 45);
        Time te28 = new Time(16, 15);

        Time ts28 = new Time(15, 0);
        Time te29 = new Time(16, 30);

        Time ts32 = new Time(15, 15);
        Time te33 = new Time(16, 45);

        Time ts29 = new Time(15, 30);
        Time te30 = new Time(17, 0);

		Time ts39 = new Time(15, 45);
        Time te40 = new Time(17, 15);

        Time ts30 = new Time(16, 0);
        Time te31 = new Time(17, 30);

		Time ts31 = new Time(16, 15);
        Time te32 = new Time(17, 45);

        Time ts35 = new Time(16, 30);
        Time te36 = new Time(18, 0);

		Time ts36 = new Time(16, 45);
        Time te37 = new Time(18, 15);

		Time ts37 = new Time(17, 00);
        Time te38 = new Time(18, 30);

		Time ts38 = new Time(17, 15);
        Time te39 = new Time(18, 45);

		Time ts40 = new Time(17, 30);
        Time te41 = new Time(19, 0);

		Time ts42 = new Time(17, 45);
        Time te42 = new Time(19, 15);

		Time ts43 = new Time(18, 00);
        Time te43 = new Time(19, 30);

		Time ts44 = new Time(18, 15);
        Time te44 = new Time(19, 45);

		Time ts45 = new Time(18, 30);
        Time te45 = new Time(20, 00);


		String[] weekDay = {"Mon", "Tue", "Wen", "Thu", "Fri"};
		Time[] statTime = {ts1, ts2, ts3, ts41, ts4, ts5, ts6, ts7, ts8, ts9, ts10, ts11, ts12, ts13, ts14, ts15, ts16, ts17, ts18, ts19, ts20, ts21, ts22, ts23, ts24, ts25, ts26, ts27, ts28, ts29, ts30, ts31, ts32, ts35, ts36, ts37, ts38, ts39, ts40, ts42, ts43, ts44, ts45};
		Time[] endTimes = {te1, te2, te3, te4, te5, te6, te7, te8, te9, te10, te11, te12, te13, te14, te15, te16, te17, te18, te19, te20, te21, te22, te23, te24, te25, te26, te27, te28, te29, te30, te31, te32, te33, te36, te37, te38, te39, te40, te41, te42, te43, te44, te45};
		lectureTimes = new ArrayList<LectureTime>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < statTime.length; j++) {
				lectureTimes.add(new LectureTime(weekDay[i], statTime[j], endTimes[j]));
			}
		}
		
		
		Classroom class1 = new Classroom(" 153 ", 100, false);
		Classroom class2 = new Classroom(" 113 ", 50, false);
		Classroom class3 = new Classroom(" 114 ", 60, false);
		Classroom class4 = new Classroom("Lab V", 25, true);
		Classroom class5 = new Classroom("Lab M", 35, true);
		Classroom class6 = new Classroom(" 112 ", 35, false);
		classrooms = new ArrayList<Classroom>(Arrays.asList(class1, class2, class3, class4, class5, class6));
		

		Professor professor1 = new Professor(1,   "A. Berisha", "Professor", ts1.toMinutes());
		Professor professor2 = new Professor(2,   "E. Bytyci", "Professor", ts1.toMinutes());
		Professor professor3 = new Professor(3,   "F. Berisha ", "Professor", ts1.toMinutes());
		Professor professor4 = new Professor(4,   "B. Fejzullahu", "Professor", ts1.toMinutes());
		Professor professor5 = new Professor(5,   "R. Limani", "Professor", ts1.toMinutes());
		Professor professor6 = new Professor(6,   "A. Shabani", "Professor", ts1.toMinutes());
		Professor professor7 = new Professor(7,   "N. Braha", "Professor", ts1.toMinutes());

		Professor professor11 = new Professor(1,  "A. Berisha", "Assistent", ts1.toMinutes());
		
        Professor professor16 = new Professor(16, "E. Bajrami", "Professor", ts1.toMinutes());
		Professor professor161 = new Professor(16,"E. Bajrami", "Assistent", ts1.toMinutes());

        Professor professor25=  new Professor(25, "B. Baxhaku", "Professor", ts1.toMinutes());
        Professor professor23 = new Professor(23, "S. Rexhepi", "Professor", ts1.toMinutes());

        Professor professor24 = new Professor(24, "S. Ahmeti", "Professor", ts1.toMinutes());
        Professor asistenti14 = new Professor(38, "A. Kalimashi", "Assistent", ts1.toMinutes());

		Professor professor41 = new Professor(41, "B. Latifi", "Assistent", ts1.toMinutes());
		Professor professor8 = new Professor(8,   "A. Hulaj", "Assistent", ts30.toMinutes());
		Professor professor9 = new Professor(9,   "M. Racaj", "Assistent", ts1.toMinutes());
        Professor professor10 = new Professor(10, "E.Rogova", "Professor", ts1.toMinutes());
        Professor professor12 = new Professor(12, "F.Marevci", "Professor", ts1.toMinutes());
        Professor professor13 = new Professor(13, "R.Gjergji", "Pofessor", ts1.toMinutes());
        Professor professor14 = new Professor(11, "G. Bujupaj", "Professor", ts1.toMinutes());
        Professor professor15 = new Professor(15, "E. Fejza", "Professor", ts1.toMinutes());
        Professor professor17 = new Professor(17, "M. Gashi", "Professor", ts1.toMinutes());
        Professor professor18 = new Professor(18,"E. Bajrami", "Professor", ts1.toMinutes());
        Professor professor19 = new Professor(19,"K. Bllaca", "Professor", ts1.toMinutes());
        Professor professor20 = new Professor(20, "M. Lohaj", "Professor", ts1.toMinutes());
        Professor professor21 = new Professor(21,"S. Avdijaj", "Professor", ts1.toMinutes());
        Professor professor22 = new Professor(22,"R. Zejnullahu" ,"Professor", ts1.toMinutes());
        Professor professor26 = new Professor(14,"F. Marevci ", "Professor", ts1.toMinutes());

        Professor asistenti2 = new Professor(26,"M. Mustafa" , "Assistent", ts1.toMinutes());
        Professor asistenti3 = new Professor(27,"Fj. Berisha", "Assistent", ts1.toMinutes());
        Professor asistenti4 = new Professor(28,"A. Ferizi", "Assistent", ts1.toMinutes());
        Professor asistenti7 = new Professor(31,"A. Hajredinaj", "Assistent", ts1.toMinutes());
        Professor asistenti8 = new Professor(32,"A. Salihu", "Assistent", ts1.toMinutes());
        Professor asistenti9 = new Professor(33,"B. Kamishi", "Assistent", ts1.toMinutes());
        Professor asistenti10 = new Professor(34,"SH. Surdulli", "Assistent", ts1.toMinutes());
        Professor asistenti11 = new Professor(35,"K. Rrmoku", "Assistent", ts1.toMinutes());
        Professor asistenti13 = new Professor(37,"V. Kelmendi", "Assistent", ts1.toMinutes());


		professors = new ArrayList<Professor>(Arrays.asList(professor1, professor2, professor3, professor4, professor5, professor6, professor7, professor8, professor9, professor11, professor161,
															professor10, professor41, professor12, professor13,professor15, professor16, professor17, professor18,professor19,professor20,
															professor21, professor22, professor23,professor24, professor14, professor25, professor26, asistenti2,asistenti3,asistenti4,asistenti7,asistenti8,
															asistenti9,asistenti10,asistenti11,asistenti13,asistenti14));



		Subject subject1 = new Subject(5001, "Grafika Kompjuterike", "shkencaKomputerike", true, "Zgj", 4);
		Subject subject2 = new Subject(5002, "Inteligjence Artificiale", "shkencaKomputerike", false, "Zgj", 4);
		Subject subject3 = new Subject(5003, "Analize Numerike 2", "shkencaKomputerike", false, "Obl", 4);
		Subject subject4 = new Subject(5004, "Teori e Gjases", "shkencaKomputerike", false, "Obl", 4);
		Subject subject5 = new Subject(5005, "OOP & GUI", "shkencaKomputerike", true, "Obl", 4);

		subject1.setProgram(shkencaKomputerike);
		subject2.setProgram(shkencaKomputerike);
		subject3.setProgram(shkencaKomputerike);
		subject4.setProgram(shkencaKomputerike);
		subject5.setProgram(shkencaKomputerike);

		Subject subject32 = new Subject(5032, "Analize 4", "matematikeFinanciare",false, "Obl", 4);
        Subject subject33 = new Subject(5033, "Matematike financiare", "matematikeFinanciare",false, "Obl", 4);
        Subject subject34 = new Subject(5033, "Teoria e gjases 2", "matematikeFinanciare",false, "Obl", 4);
        Subject subject35 = new Subject(5035, "Menaxhimi bankar", "matematikeFinanciare",true, "Zgj", 4);
        Subject subject36 = new Subject(5036, "Analiza financiare", "matematikeFinanciare",false, "Zgj", 4);

		subject32.setProgram(matematikeFinanciare);
		subject33.setProgram(matematikeFinanciare);
		subject34.setProgram(matematikeFinanciare);
		subject35.setProgram(matematikeFinanciare);
		subject36.setProgram(matematikeFinanciare);


		Subject subject17 = new Subject(5017, "Integralet", "matematikeEPergjithshme",false, "Obl", 4);
        Subject subject21 = new Subject(5021, "Teoria e Numrave", "matematikeEPergjithshme",false, "Obl", 4);
        Subject subject19 = new Subject(5019, "Gjeometria deskriptive", "matematikeEPergjithshme",false, "Obl", 4);
        Subject subject20 = new Subject(5020, "Baza e te dhenave", "matematikeEPergjithshme",false, "Zgj", 4);
        Subject subject22 = new Subject(5022, "Matematika Numerike", "matematikeEPergjithshme",false, "Zgj", 4);

		subject17.setProgram(matematikeEPergjithshme);
		subject21.setProgram(matematikeEPergjithshme);
		subject19.setProgram(matematikeEPergjithshme);
		subject20.setProgram(matematikeEPergjithshme);
		subject22.setProgram(matematikeEPergjithshme);


		subject1.addProfessors(new ArrayList<Professor>(Arrays.asList(professor1, professor11)));
		subject2.addProfessors(new ArrayList<Professor>(Arrays.asList(professor2, professor8)));
		subject3.addProfessors(new ArrayList<Professor>(Arrays.asList(professor3, professor9)));
		subject4.addProfessors(new ArrayList<Professor>(Arrays.asList(professor4, professor41)));
		subject5.addProfessors(new ArrayList<Professor>(Arrays.asList(professor3, professor8)));

		subject17.addProfessors(new ArrayList<Professor>(Arrays.asList(professor20, asistenti4)));
		subject19.addProfessors(new ArrayList<Professor>(Arrays.asList(professor19, professor41)));
		subject22.addProfessors(new ArrayList<Professor>(Arrays.asList(professor21, professor9)));
		subject21.addProfessors(new ArrayList<Professor>(Arrays.asList(professor16, asistenti13)));
		subject20.addProfessors(new ArrayList<Professor>(Arrays.asList(professor10, asistenti8)));

		subject32.addProfessors(new ArrayList<Professor>(Arrays.asList(professor4, asistenti4)));
		subject33.addProfessors(new ArrayList<Professor>(Arrays.asList(professor16, professor161)));
		subject34.addProfessors(new ArrayList<Professor>(Arrays.asList(professor25, professor41)));
		subject35.addProfessors(new ArrayList<Professor>(Arrays.asList(professor15, asistenti14)));
		subject36.addProfessors(new ArrayList<Professor>(Arrays.asList(professor24, asistenti14)));


		subjects = new ArrayList<Subject>(Arrays.asList(subject1, subject2, subject3, subject4, subject5,
														subject17,subject19,subject20, subject21, subject22,  
														subject32,subject33,subject34,subject35, subject36));

		studentsGroups = new ArrayList<>();
		StudentsGroup g1shk = new StudentsGroup(101, "ShK-Gr1", 30, shkencaKomputerike, true);
		StudentsGroup g2shk = new StudentsGroup(102, "ShK-Gr2", 25, shkencaKomputerike, true);
		StudentsGroup gshkT = new StudentsGroup(104, "ShK-GrP", 55, shkencaKomputerike, true);
		StudentsGroup gshk = new StudentsGroup(103, "ShK-Gr", 55, shkencaKomputerike, false);

		StudentsGroup g1m = new StudentsGroup(201, "M-Gr1", 20, matematikeEPergjithshme, true);
		StudentsGroup g2m = new StudentsGroup(202, "M-Gr2", 20, matematikeEPergjithshme, true);
		StudentsGroup gmT = new StudentsGroup(204, "M-GrP", 40, matematikeEPergjithshme, true);
		StudentsGroup gm = new StudentsGroup(203, "M-Gr", 40, matematikeEPergjithshme, false);

		StudentsGroup gmf = new StudentsGroup(304, "MF-Gr", 25, matematikeFinanciare, false);
		StudentsGroup gmfT = new StudentsGroup(303, "MF-Gr1", 25, matematikeFinanciare, true);


		studentsGroups.add(g1shk);
		studentsGroups.add(g2shk);
		studentsGroups.add(gshk);
		studentsGroups.add(g1m);
		studentsGroups.add(g2m);
		studentsGroups.add(gm);
		studentsGroups.add(gmfT);
		studentsGroups.add(gmT);
		studentsGroups.add(gshkT);
		studentsGroups.add(gmf);

		matematikeEPergjithshme.addStudentGroups(new ArrayList<StudentsGroup>(Arrays.asList(gm, g1m, g2m, gmT)));
		shkencaKomputerike.addStudentGroups(new ArrayList<StudentsGroup>(Arrays.asList(gshk, g1shk, g2shk, gshkT)));
		matematikeFinanciare.addStudentGroups(new ArrayList<StudentsGroup>(Arrays.asList(gmf, gmfT)));
		
		gm.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject17,subject19,subject20, subject21, subject22)));
		gmT.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject17,subject19,subject20, subject21))); 
		g1m.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject22))); 
		g2m.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject22))); 

		gshk.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject1, subject2, subject3, subject4, subject5)));
		gshkT.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject2, subject4))); 
		g1shk.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject1, subject3, subject5))); 
		g2shk.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject1, subject3, subject5)));

		gmf.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject32,subject33,subject34,subject35, subject36)));
		gmfT.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject32,subject33,subject34,subject35, subject36))); 
		return this;
        
	}
    
	public ArrayList<StudentsGroup> getAllStudentsGroups() {
		return studentsGroups;
	}

	public ArrayList<StudentsGroup> getStudentGroupsPerProgram(String programName) {
		ArrayList<StudentsGroup> rez = new ArrayList<>();
		for(StudentsGroup sg : studentsGroups) {
			if (sg.getProgram().getName().equals(programName)) {
				rez.add(sg);
			}
		}
		return rez;
	}

	public ArrayList<StudentsGroup> getStudentGroupsPerProgram(String subject, String programName) {
		ArrayList<StudentsGroup> rez = new ArrayList<>();
		for(StudentsGroup sg : studentsGroups) {
			if (sg.getProgram().getName().equals(programName) && sg.getSubject(subject) != null) {
				rez.add(sg);
			}
		}
		return rez;
	}

	public ArrayList<Classroom> getAllClassrooms() {	
		return classrooms;
	}

	public ArrayList<Classroom> getClassrooms(boolean isLabRequired) {
		ArrayList<Classroom> rez = new ArrayList<>(); 
  		for (Classroom classroom : classrooms) {
				if(classroom.isLab() == isLabRequired) {
					rez.add(classroom);
				}
			}
		return rez;
	}

	public ArrayList<Professor> getProfessorsPerSubject(Subject subject, boolean isExercise)  {
		return subject.getProfessors(isExercise);
	}

	public ArrayList<Subject> getSubjectsPerSemester(int semester) {
		ArrayList<Subject> rez = new ArrayList<>();
		
		for (Subject subject : subjects) {
			if(subject.getSemester() == semester){
				rez.add(subject);
			}
		}
		return rez;
	}

	
	public ArrayList<Subject> getSubjectsPerSemester(String progName, int semester) {
		ArrayList<Subject> rez = new ArrayList<>();
		for (Subject subject : subjects) {
			if(subject.getSemester() == semester && subject.getProgramN().equals(progName)){
				rez.add(subject);
			}
		}
		return rez;
	}
	
	
    public ArrayList<Professor> getProfessors()  {
		return professors;
	}
	
   	public ArrayList<Subject> getSubjects()  {
		return subjects;
	}
	
   	public ArrayList<Program> getPrograms()  {
		return programs;
	}

	public ArrayList<LectureTime> getLectureTimes() {
		return lectureTimes;
	}
	
   	public int getNumberOfClasses() {
		return this.numberOfClasses;     
	}
}