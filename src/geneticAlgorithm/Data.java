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

		Program shkencaKompjuterike =      new Program("Shkence Kompjuterike", department);
        programs = new ArrayList<Program>(Arrays.asList(shkencaKompjuterike));
    

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
		Classroom class4 = new Classroom("Lab V", 30, true);
		Classroom class5 = new Classroom("Lab M", 50, true);
		Classroom class6 = new Classroom(" 112 ", 30, false);
		classrooms = new ArrayList<Classroom>(Arrays.asList(class1, class2, class3, class4, class5, class6));
		
		
		Professor professor1 = new Professor(1, "R. Limani", "Professor", ts16.toMinutes());
		Professor professor2 = new Professor(2, "B. Hasani", "Assistant", ts1.toMinutes());
		Professor professor3 = new Professor(3, "Q. Gashi"	, "Professor", ts8.toMinutes());
		Professor professor4 = new Professor(4, "M. Mustafa", "Assistant", ts1.toMinutes());
		Professor professor5 = new Professor(5, "F. Berisha", "Professor", ts12.toMinutes());
		Professor professor6 = new Professor(6, "A. Salihu", "Assistant", ts24.toMinutes());
		Professor professor7 = new Professor(7, "E. Bytyçi", "Professor", ts1.toMinutes());
		Professor professor7a = new Professor(71, "E. Bytyçi", "Assistant", ts1.toMinutes());
		Professor professor8 = new Professor(8, "Fj. Berisha", "Assistant", ts1.toMinutes());
		Professor professor9 = new Professor(9, "V. Caka", "Professor", ts1.toMinutes());
		Professor professor9a = new Professor(91, "V. Caka", "Assistant", ts1.toMinutes());
		Professor professor10 = new Professor(10, "N. Braha","Professor" , ts1.toMinutes());
		Professor professor11 = new Professor(11, "M. Raci", "Assistant", ts20.toMinutes());
		Professor professor12 = new Professor(12, "E. Rogova", "Professor", ts1.toMinutes());
		Professor professor13 = new Professor(13, "K. Rrmoku", "Assistant", ts1.toMinutes());
		Professor professor14 = new Professor(14, "A. Berisha", "Professor", ts1.toMinutes());
		Professor professor14a = new Professor(141, "A. Berisha", "Assistant", ts1.toMinutes());
		Professor professor15 = new Professor(15, "A. Shabani", "Professor", ts1.toMinutes());
		Professor professor15a = new Professor(151, "A. Shabani", "Assistant", ts1.toMinutes());
		Professor professor16 = new Professor(16, "E. Aliaga", "Professor", ts24.toMinutes());
		Professor professor17 = new Professor(17, "B. Latifi", "Assistant", ts8.toMinutes());
		Professor professor18 = new Professor(18,"E. Bajrami", "Professor", ts29.toMinutes());
		Professor professor19 = new Professor(19, "A. Hulaj", "Assistant", ts30.toMinutes());
		Professor professor20 = new Professor(20, "A. Elshani", "Professor", ts10.toMinutes());
		Professor professor21 = new Professor(21, "A. Kalimashi", "Assistant", ts38.toMinutes());
		Professor professor22 = new Professor(22, "Q. Gashi", "Professor", ts8.toMinutes());
		Professor professor23 = new Professor(23, "A. Ferizi", "Assistant", ts26.toMinutes());

					
		professors = new ArrayList<Professor>(Arrays.asList(professor1, professor2, professor3, professor4, professor5, professor6, professor7, professor7a, professor8, professor9, professor9a, professor10, 
															professor11, professor12, professor13, professor14, professor14a, professor15, professor15a, professor16, professor17, professor18,professor19,professor20,
															professor21, professor22, professor23));


         Subject subject1 = new Subject(5000, "Matematika elementare", 6, "Shkence Kompjuterike", false, "O", 1);
		 Subject subject2 = new Subject(5001, "Matematika diskrete", 6, "Shkence Kompjuterike", false, "O", 1);
		 Subject subject3 = new Subject(5002, "Programimi dhe algoritmet", 6, "Shkence Kompjuterike", true, "O", 1);
		 Subject subject4 = new Subject(5003, "Hyrje ne shkencat kompjuterike", 6, "Shkence Kompjuterike", true, "O", 1);
		 Subject subject5 = new Subject(5004, "Gjuhe angleze I", 5, "Shkence Kompjuterike", false, "O", 1);
		 Subject subject6 = new Subject(5005, "Kalkulus II", 6, "Shkence Kompjuterike", false, "O", 3);
		 Subject subject7 = new Subject(5006, "Analize numerike I", 6, "Shkence Kompjuterike", true, "O", 3);
		 Subject subject8 = new Subject(5007, "Bazat e te dhenave", 6, "Shkence Kompjuterike", true, "O", 3);
		 Subject subject9 = new Subject(5008, "Arkitektura e kompjutereve dhe sistemet operative", 6, "Shkence Kompjuterike", true, "O", 3);
		 Subject subject10 = new Subject(5009, "Siguria e te dhenave ne kompjuter", 6, "Shkence Kompjuterike", true, "Z", 3);
		 Subject subject11 = new Subject(5010, "Matematike konkrete", 5, "Shkence Kompjuterike", false, "Z", 3);
		 Subject subject12 = new Subject(5011, "Statistike", 6, "Shkence Kompjuterike", true, "O", 5);
		 Subject subject13 = new Subject(5012, "Programimi ne WWW", 7, "Shkence Kompjuterike", true, "O", 5);
		 Subject subject14 = new Subject(5013, "Analize e algoritmeve", 7, "Shkence Kompjuterike", true, "O", 5);
		 Subject subject15 = new Subject(5014, "Kontabiliteti", 5, "Shkence Kompjuterike", false, "Z", 5);
		 Subject subject16 = new Subject(5015, "Analiza e te dhenave", 5, "Shkence Kompjuterike", false, "Z", 5);
		 Subject subject17 = new Subject(5016, "Modelim softuerik", 5, "Shkence Kompjuterike", false, "Z", 5);
		 Subject subject18 = new Subject(5017, "Teori e lojerave", 5, "Shkence Kompjuterike", false, "Z", 5);

		
		subject1.setProgram(shkencaKompjuterike);
		subject2.setProgram(shkencaKompjuterike);
		subject3.setProgram(shkencaKompjuterike);
		subject4.setProgram(shkencaKompjuterike);
		subject5.setProgram(shkencaKompjuterike);
		subject6.setProgram(shkencaKompjuterike);
		subject7.setProgram(shkencaKompjuterike);
		subject8.setProgram(shkencaKompjuterike);
		subject9.setProgram(shkencaKompjuterike);
		subject10.setProgram(shkencaKompjuterike);
		subject11.setProgram(shkencaKompjuterike);
		subject12.setProgram(shkencaKompjuterike);
		subject13.setProgram(shkencaKompjuterike);
		subject14.setProgram(shkencaKompjuterike);
		subject15.setProgram(shkencaKompjuterike);
		subject16.setProgram(shkencaKompjuterike);
		subject17.setProgram(shkencaKompjuterike);
		subject18.setProgram(shkencaKompjuterike);
				

		subject1.addProfessors(new ArrayList<Professor>(Arrays.asList(professor1, professor2)));
		subject2.addProfessors(new ArrayList<Professor>(Arrays.asList(professor3, professor4)));
		subject3.addProfessors(new ArrayList<Professor>(Arrays.asList(professor5, professor6)));
		subject4.addProfessors(new ArrayList<Professor>(Arrays.asList(professor7, professor8)));
		subject5.addProfessors(new ArrayList<Professor>(Arrays.asList(professor9, professor9a)));

		subject6.addProfessors(new ArrayList<Professor>(Arrays.asList(professor10, professor4)));
		subject7.addProfessors(new ArrayList<Professor>(Arrays.asList(professor5, professor11)));
		subject8.addProfessors(new ArrayList<Professor>(Arrays.asList(professor12, professor13)));
		subject9.addProfessors(new ArrayList<Professor>(Arrays.asList(professor12, professor13)));
		subject10.addProfessors(new ArrayList<Professor>(Arrays.asList(professor14, professor14a)));
		subject11.addProfessors(new ArrayList<Professor>(Arrays.asList(professor15, professor15a)));
		

		subject12.addProfessors(new ArrayList<Professor>(Arrays.asList(professor16, professor17)));
		subject13.addProfessors(new ArrayList<Professor>(Arrays.asList(professor12, professor13)));
		subject14.addProfessors(new ArrayList<Professor>(Arrays.asList(professor18, professor19)));
		subject15.addProfessors(new ArrayList<Professor>(Arrays.asList(professor20, professor21)));
		subject16.addProfessors(new ArrayList<Professor>(Arrays.asList(professor7, professor7a)));
		subject17.addProfessors(new ArrayList<Professor>(Arrays.asList(professor7, professor8)));
		subject18.addProfessors(new ArrayList<Professor>(Arrays.asList(professor22, professor23)));

		

		subjects = new ArrayList<Subject>(Arrays.asList(subject1, subject2, subject3, subject4, subject5, subject6, subject7,
														subject8, subject9, subject10, subject11, subject12, subject13, subject14,
														subject15, subject16, subject17, subject18));
													

		studentsGroups = new ArrayList<>();
		StudentsGroup grL = new StudentsGroup(100, "Ligjerata", 60, shkencaKompjuterike, false, 1);
		StudentsGroup grU = new StudentsGroup(101, "Ushtrime", 60, shkencaKompjuterike, true, 1);
		StudentsGroup grU1 = new StudentsGroup(102, "Ushtrime - Gr.1", 30, shkencaKompjuterike, true, 1);
		StudentsGroup grU2 = new StudentsGroup(103, "Ushtrime - Gr.2", 30, shkencaKompjuterike, true, 1);

		StudentsGroup agrL = new StudentsGroup(104, "Ligjerata", 60, shkencaKompjuterike, false, 3);
		StudentsGroup agrU = new StudentsGroup(105, "Ushtrime", 60, shkencaKompjuterike, true, 3);
		StudentsGroup agrU1 = new StudentsGroup(106, "Ushtrime - Gr.1", 30, shkencaKompjuterike, true, 3);
		StudentsGroup agrU2 = new StudentsGroup(107, "Ushtrime - Gr.2", 30, shkencaKompjuterike, true, 3);
		StudentsGroup agrU3 = new StudentsGroup(106, "Ushtrime - Gr.3", 30, shkencaKompjuterike, true, 3);
		StudentsGroup agrU4 = new StudentsGroup(107, "Ushtrime - Gr.4", 30, shkencaKompjuterike, true, 3);
		StudentsGroup agrL1 = new StudentsGroup(104, "Ligjerata", 20, shkencaKompjuterike, false, 3);


		StudentsGroup bgrL = new StudentsGroup(108, "Ligjerata", 50, shkencaKompjuterike, false, 5);
		StudentsGroup bgrU = new StudentsGroup(109, "Ushtrime", 50, shkencaKompjuterike, true, 5);
		StudentsGroup bgrU1 = new StudentsGroup(110, "Ushtrime - Gr.1", 25, shkencaKompjuterike, true, 5);
		StudentsGroup bgrU2 = new StudentsGroup(111, "Ushtrime - Gr.2", 25, shkencaKompjuterike, true, 5);
		StudentsGroup bgrU3 = new StudentsGroup(112, "Ushtrime - Gr.3", 25, shkencaKompjuterike, true, 5);
		StudentsGroup bgrU4 = new StudentsGroup(113, "Ushtrime - Gr.4", 25, shkencaKompjuterike, true, 5);
		StudentsGroup bgrL1 = new StudentsGroup(114, "Ligjerata", 30, shkencaKompjuterike, true, 5);
		StudentsGroup bgrUv = new StudentsGroup(115, "Ushtrime", 30, shkencaKompjuterike, true, 5);

		
		studentsGroups.add(grL);
		studentsGroups.add(grU);
		studentsGroups.add(grU1);
		studentsGroups.add(grU1);
		studentsGroups.add(agrL);
		studentsGroups.add(agrU);
		studentsGroups.add(agrU1);
		studentsGroups.add(agrU2);
		studentsGroups.add(agrU3);
		studentsGroups.add(agrU4);
		studentsGroups.add(agrL1);
		studentsGroups.add(bgrL);
		studentsGroups.add(bgrU);
		studentsGroups.add(bgrU1);
		studentsGroups.add(bgrU2);
		studentsGroups.add(bgrU3);
		studentsGroups.add(bgrU4);
		studentsGroups.add(bgrL1);
		studentsGroups.add(bgrUv);


		shkencaKompjuterike.addStudentGroups(new ArrayList<StudentsGroup>(Arrays.asList(grL, grU, grU1, grU2, agrL, agrL1, agrU, agrU1, agrU2, agrU3, agrU4, bgrL, bgrL1, bgrU, bgrU1, bgrU2, bgrU3, bgrU4, bgrUv)));
		
		grL.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject1, subject2, subject3, subject4, subject5)));
		grU.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject5))); 
		grU1.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject1, subject2, subject3, subject4))); 
		grU2.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject1, subject2, subject3, subject4)));

		agrL.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject6, subject7, subject8, subject9, subject10)));
		agrL1.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject11)));
		agrU.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject6))); 
		agrU1.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject7, subject8, subject9, subject10))); 
		agrU2.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject7, subject8, subject9, subject10)));
		agrU3.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject10))); 
		agrU4.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject10)));

		bgrL.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject12, subject13, subject14, subject17)));
		bgrL1.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject15, subject16, subject18)));
		bgrU.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject12, subject17))); 
		bgrUv.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject15, subject18))); 
		bgrU1.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject13, subject14))); 
		bgrU2.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject13, subject14)));
		bgrU3.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject14))); 
		bgrU4.getSubjects().addAll(new ArrayList<Subject>(Arrays.asList(subject14)));

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
