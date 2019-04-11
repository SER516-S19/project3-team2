JAVAC=$(shell which javac)
JAVA_EXEC=$(shell which java)

JSON_LIB=utils/lib/gson-2.8.5.jar
CROSS_APPLICATION_SRC=utils/src/ConstantTable.java utils/src/JsonUtils.java utils/src/Question.java

BUILD_DIR=bin

PROFESSOR_MAIN_FILE=professor/src/ProfessorMain.java
PROFESSOR_CONTROLLER_FILES=professor/src/controller/*.java
PROFESSOR_VIEW_FILES=professor/src/view/*.java

.PHONY: 
professor: $(JSON_LIB) $(CROSS_APPLICATION_SRC) $(PROFESSOR_MAIN_FILE) $(PROFESSOR_VIEW_FILES) $(PROFESSOR_CONTROLLER_FILES)
	$(JAVAC) -d $(BUILD_DIR) -cp $^	

.PHONY: 
run-professor:
	cd $(BUILD_DIR); $(JAVA_EXEC) -cp ../$(JSON_LIB): ProfessorMain; cd ../

.PHONY: 
clean-professor:
	rm -rf $(BUILD_DIR)/professor
	rm -rf $(BUILD_DIR)/ProfessorMain

.PHONY:
clean-crosslib:
	rm -rf $(BUILD_DIR)/utils

.PHONY: 
clean: clean-professor
	rm -rf $(BUILD_DIR)
