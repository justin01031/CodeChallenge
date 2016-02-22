JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		com/interview/gamehandle/GameHandler.java \
		com/interview/matchmaking/Match.java\
		com/interview/matchmaking/Matchmaker.java\
		com/interview/matchmaking/MatchmakerImpl.java\
		com/interview/matchmaking/Player.java\
		com/interview/matchmaking/rule/MatchingRule.java\
		com/interview/matchmaking/rule/PlayerScore.java\
		com/interview/matchmaking/rule/BasicMatchingRule.java\
		com/interview/matchmaking/SampleData.java\
		com/interview/matchmaking/TeamOrganizer.java\
		com/interview/score/rule/ScoreRule.java \
		com/interview/score/rule/BasicScoreRule.java \
		test/java/main.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
		find . -name "*.class"|xargs rm -rf

run:
	java test.java.main

##java test.java.main