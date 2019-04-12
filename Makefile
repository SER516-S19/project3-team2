JAVAC=$(shell which javac)
JAVA_EXEC=$(shell which java)
JAR=$(shell which jar)

JSON_LIB=utils/lib/gson-2.8.5.jar
CROSS_APPLICATION_SRC=utils/src/ConstantTable.java utils/src/JsonUtils.java utils/src/Question.java

BUILD_DIR=bin

PROFESSOR_JAR_NAME=Professor.jar

PROFESSOR_MAIN_FILE=professor/src/ProfessorMain.java
PROFESSOR_CONTROLLER_FILES=professor/src/controller/*.java
PROFESSOR_MODEL_FILES=professor/src/model/*.java
PROFESSOR_VIEW_FILES=professor/src/view/*.java

PROFESSOR_JAR_CONFIG_FILE=professor/Manifest.mf

STUDENT_JAR_NAME=Student.jar

STUDENT_MAIN_FILE=student/src/StudentMain.java
STUDENT_CONTROLLER_FILES=student/src/controller/*.java
STUDENT_VIEW_FILES=student/src/view/*.java
STUDENT_MODEL_FILES=student/src/model/*.java

STUDENT_JAR_CONFIG_FILE=student/Manifest.mf

.PHONY: all
all: 
	$(error Please specify build target: make pack-professor || make pack-student)

# Professor section
.PHONY: professor-obj
professor-obj: $(JSON_LIB) $(CROSS_APPLICATION_SRC) $(PROFESSOR_MAIN_FILE) $(PROFESSOR_MODEL_FILES) $(PROFESSOR_VIEW_FILES) $(PROFESSOR_CONTROLLER_FILES)
	$(JAVAC) -d $(BUILD_DIR) -cp $^	

.PHONY: pack-professor
pack-professor: professor-obj
	cd $(BUILD_DIR); $(JAR) cfm $(PROFESSOR_JAR_NAME) ../$(PROFESSOR_JAR_CONFIG_FILE) * ../$(JSON_LIB)
	make clean-professor-obj
	make clean-crosslib

.PHONY: run-professor
run-professor: pack-professor
	$(JAVA_EXEC) -jar $(BUILD_DIR)/$(PROFESSOR_JAR_NAME)

# Student section
.PHONY: student-obj
student-obj: $(JSON_LIB) $(CROSS_APPLICATION_SRC) $(STUDENT_MAIN_FILE) $(STUDENT_MODEL_FILES) $(STUDENT_CONTROLLER_FILES) $(STUDENT_VIEW_FILES) 
	$(JAVAC) -d $(BUILD_DIR) -cp $^	

.PHONY: pack-student
pack-student: student-obj
	cd $(BUILD_DIR); $(JAR) cfm $(STUDENT_JAR_NAME) ../$(STUDENT_JAR_CONFIG_FILE) * ../$(JSON_LIB)
	make clean-student-obj
	make clean-crosslib

.PHONY: run-student
run-student: pack-student
	$(JAVA_EXEC) -jar $(BUILD_DIR)/$(STUDENT_JAR_NAME)

# Clean
.PHONY: clean-professor-obj
clean-professor-obj:
	rm -rf $(BUILD_DIR)/professor
	rm -rf $(BUILD_DIR)/ProfessorMain*.class

.PHONY: clean-student-obj
clean-student-obj:
	rm -rf $(BUILD_DIR)/student
	rm -rf $(BUILD_DIR)/StudentMain*.class

.PHONY: clean-crosslib
clean-crosslib:
	rm -rf $(BUILD_DIR)/utils

.PHONY: clean
clean: clean-professor-obj clean-student-obj clean-crosslib
	rm -rf $(BUILD_DIR)
