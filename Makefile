JAVAC=$(shell which javac)
JAVA_EXEC=$(shell which java)
JAR=$(shell which jar)

JSON_LIB=utils/lib/gson-2.8.5.jar
CROSS_APPLICATION_SRC=utils/src/ConstantTable.java utils/src/JsonUtils.java utils/src/Question.java

BUILD_DIR=bin

PROFESSOR_JAR_NAME=Professor.jar

PROFESSOR_MAIN_FILE=professor/src/ProfessorMain.java
PROFESSOR_CONTROLLER_FILES=professor/src/controller/*.java
PROFESSOR_VIEW_FILES=professor/src/view/*.java

PROFESSOR_JAR_CONFIG_FILE=professor/Manifest.mf

.PHONY: all
all: 
	$(error Please specify build target: make pack-professor || make pack-student)

.PHONY: professor-obj
professor-obj: $(JSON_LIB) $(CROSS_APPLICATION_SRC) $(PROFESSOR_MAIN_FILE) $(PROFESSOR_VIEW_FILES) $(PROFESSOR_CONTROLLER_FILES)
	$(JAVAC) -d $(BUILD_DIR) -cp $^	

.PHONY: pack-professor
pack-professor: professor-obj
	cd $(BUILD_DIR); $(JAR) cfm $(PROFESSOR_JAR_NAME) ../$(PROFESSOR_JAR_CONFIG_FILE) * ../$(JSON_LIB)
	make clean-professor-obj
	make clean-crosslib

.PHONY: run-professor
run-professor: pack-professor
	$(JAVA_EXEC) -jar $(BUILD_DIR)/$(PROFESSOR_JAR_NAME)

.PHONY: pack-student
pack-student:
	$(error Not implement yet)

.PHONY: clean-professor-obj
clean-professor-obj:
	rm -rf $(BUILD_DIR)/professor
	rm -rf $(BUILD_DIR)/ProfessorMain*.class

.PHONY: clean-crosslib
clean-crosslib:
	rm -rf $(BUILD_DIR)/utils

.PHONY: clean
clean: clean-professor-obj
	rm -rf $(BUILD_DIR)
