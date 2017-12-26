class Color 
    def self.add_item(key,value)
        @hash ||= {}
        @hash[key]=value
    end
    
    def self.const_missing(key)
        @hash[key]
    end    
    
    def self.each
        @hash.each {|key,value| yield(key,value)}
    end
    
    @@B = Color.add_item :BLUE, 1
    @@R = Color.add_item :RED, 2
    @@Y = Color.add_item :YELLOW, 3


# one way to access class variables
    class << self
    	def B
    		@@B
    	end

    	def R
    		@@R
    	end
    end

# other way to access class variables
    def self.B
        @@B
    end
end
 
=begin
#That's it! We can now use our enum :
my_color = Color::RED
 
#And we can loop
Color.each do |key,value|
  puts value
end
puts my_color
=end

puts Color.add_item :WHITE, 4
puts Color.add_item :ORANGE, 5
puts Color.B
puts Color.R