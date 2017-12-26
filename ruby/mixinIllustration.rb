=begin
module T
	@var1 = "module declaration"
	def m1
		puts "m1"
		puts @var1
	end

	def self.m2
		puts "m2"
	end
end


class T_Illustration
	include T
	@var1 = "InstanceVariable"
	@@var2 = "ClassVariable"
end


obj = T_Illustration.new
T_Illustration.T.m2
=end

module D  
  def initialize(name)  
    @name = name  
    @param = "fixed" 
  end  

  def to_s  
    @name  
  end  
end  
  
module Debug  
  include D	

  def getParam
  	@param
  end

  # Methods that act as queries are often  
  # named with a trailing ?  
  def who_am_i?  
    "#{self.class.name} (\##{self.object_id}): #{self.to_s} #{self.getParam}"  
  end  

  def Debug.t1
  	puts 't1'
  end
end  
  
class Phonograph  
  # the include statement simply makes a reference to a named module  
  # If that module is in a separate file, use require to drag the file in  
  # before using include  
  include Debug  
  # ...  
end  
  
class EightTrack  
  include Debug  
  # ...  
end  
  
ph = Phonograph.new("West End Blues")  
et = EightTrack.new("Real Pillow")  
puts ph.who_am_i?  
puts et.who_am_i?  
puts Phonograph.t1