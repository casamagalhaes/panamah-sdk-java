export PATH := $(PATH):.
export JACOCO_SOURCE_PATH := src/main/java

cov: 
	mvn clean test install
	chmod +x test-reporter-latest-linux-amd64
	test-reporter-latest-linux-amd64 before-build
	test-reporter-latest-linux-amd64 format-coverage target/site/jacoco/jacoco.xml --input-type jacoco
	test-reporter-latest-linux-amd64 upload-coverage --id $(CODECLIMATE_PANAMAH_SDK_JAVA_REPORTER_ID)
	# test-reporter-latest-linux-amd64 after-build -t jacoco --id $(CODECLIMATE_PANAMAH_SDK_JAVA_REPORTER_ID)
