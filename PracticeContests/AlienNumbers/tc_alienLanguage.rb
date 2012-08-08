# File: tc_alienLanguage.rb

require "alienLanguage"
require "test/unit"

class TestAlienLanguage < Test::Unit::TestCase
	@@testInFile = "test.in"
	@@testOutFile = "test.out"

	def verify_test_case
		output = alienLanguage.process(@@testInFile)
		outputLines = output.split

		testOutputFile = File.open(@@testOutFile, "r")
	end

end
