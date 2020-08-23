
JCC = javac
JFLAGS = -g

default: Graph.class Tode.class ListGraph.class Main.class

Graph.class: Graph.java
	$(JCC) $(JFLAGS) Graph.java

Tode.class: Tode.java
	$(JCC) $(JFLAGS) Tode.java

ListGraph.class: ListGraph.java
	$(JCC) $(JFLAGS) ListGraph.java

Main.class: Main.java 
	$(JCC) $(JFLAGS) Main.java

clean: 
	$(RM) *.class