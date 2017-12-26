=begin

In Ruby, public, private and protected apply only to methods. Instance and class variables are 
	encapsulated and effectively private, and constants are effectively public. There is no way to make 
	an instance variable accessible from outside a class (except by defining an accessor method). 
	And there is no way to define a constant that is inaccessible to outside use.

Ruby gives you three levels of protection:

1. Public methods can be called by everyone - no access control is enforced. A class's instance methods 
	(these do not belong only to one object; instead, every instance of the class can call them) are 
	public by default; anyone can call them. The initialize method is always private.

2. Protected methods can be invoked only by objects of the defining class and its subclasses. Access is 
	kept within the family. However, usage of protected is limited.

3. Private methods cannot be called with an explicit receiver - the receiver is always self. This means 
	that private methods can be called only in the context of the current object; you cannot invoke 
	another object's private methods.
	
NOTE:: Access control is determined dynamically, as the program runs, not statically. You will get an
		access violation only when the code attempts to execute the restricted method. Ruby does not
		support access control to the variables.
=end


module Basics

	class FourWheels
		attr_accessor :wheels
		def initialize(wheels)
			self.wheels = wheels
		end
	end

	class Domain 

		attr_accessor :worldwide, :nations
		def initialize(options)
			self.worldwide = options['worldwide']
			self.nations = options['nations_serves']
		end
	end


	class BaseClass
		attr_accessor :var1

		def initialize(hash)
			self.var1 = hash[:var1]
		end
	end


	class AccessControlExample
		
		def var1
			:var1
		end

		def var2
			:var2
		end

		def var3
			:var3
		end

		def var4
			:var4
		end

		def initialize(hash)
			@var1 = hash[:var1]
			@var2 = hash[:var2]
			@var3 = hash[:var3]
			@var4 = hash[:var4]
		end

		public :var1
		protected :var2
		private :var3
	end


end



# example to show symbol instance variables
	hash = Hash.new
	hash[:var1] = :object1

	baseObject1 = Basics::BaseClass.new(hash)

	hash[:var1] = :object2
	baseObject2 = Basics::BaseClass.new(hash)

	puts "O1:: #{baseObject1.var1} --------  O2:: #{baseObject2.var1}"


# example to show access control of ruby
	hash[:var1] = :public
	hash[:var2] = :protected
	hash[:var3] = :private
	hash[:var4] = :default

	object = Basics::AccessControlExample.new(hash)

	puts "accessing public::  #{object.var1}"
	#puts "accessing protected::   #{object.var2}"	removing identation will give error, shown following way to use protected 
	#puts "accessing private:: 	#{object.var3}"   removing identation will give error
	puts "accessing default:: 	#{object.var4}"





# how to use protected access control

class Person  
  def initialize(age)  
    @age = age  
  end  
  def age  
    @age  
  end  
  def compare_age(c)  
    if c.age > age  
      "The other object's age is bigger."  
    else  
      "The other object's age is the same or smaller."  
    end  
  end  
  protected :age  
end  
  
chris = Person.new(25)  
marcos = Person.new(34)  
puts chris.compare_age(marcos)

