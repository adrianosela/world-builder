NAME:=$(shell basename `git rev-parse --show-toplevel`)
RELEASE:=$(shell git rev-parse --verify --short HEAD)
VERSION = 0.1.0

all: preview

preview:
	mvn compile exec:java -Dexec.mainClass=com.adrianosela.worldbuilder.preview.Preview
