module Test

class MobileTesting 
	attr_accessor :build
	attr_accessor :specs
	attr_accessor :company

	def initialize(build, specs, company)
		@build=build
		@specs=specs
		@company=company
	end
end
end


class Testing
	include Test
	attr_accessor :qa
	attr_accessor :developing_company
	attr_accessor :area
	def initialize(qa, developing_company, area)
		@qa=qa
		@developing_company=developing_company
		@area=area
	end

	def access_mobile_testing 
		MobileTesting.new("Good","TopEnd","Motorola").specs
	end
end

testing = Testing.new("SourceFuse","SourceFuse","IT")
puts testing.qa
puts Test::MobileTesting.new("Good","TopEnd","Motorola").build
puts Testing.new("SourceFuse","SourceFuse","IT").access_mobile_testing


fibs = [1, 1, 2, 3, 5, 8, 13, 21, 34, 55]

# Add your code below!

doubled_fibs = fibs.each{ |n| n*3 }


for i in 0..doubled_fibs.length
	puts doubled_fibs[i]
end


