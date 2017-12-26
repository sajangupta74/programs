class BaseClass
	def initialize
		puts "Executing BaseClass initialize method"
		@n=10
	end

	def increase_n
		@n = @n * 20
	end

	def m1
		puts "Executing m1 method of BaseClass"
	end
end

class DerivedClass < BaseClass
	def initialize
		super
		puts "Executing DerivedClass initialize method"
	end

	def m1
		puts "Executing m2 method of DerivedClass"
		puts "value of n #{@n}"
	end
end


obj1 = DerivedClass.new
obj1.increase_n
obj1.m1

