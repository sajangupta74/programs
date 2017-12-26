$LOAD_PATH.push(Dir.pwd)
require 'module1.rb'

module Vehicle
	
	class Car < Basics::FourWheels

		include Basics

		attr_accessor :type, :brand

		def initialize(options)
			super options['wheels']
			self.type = options['type']
			self.brand = options['brand']
		end

		def test

			options = {
				'worldwide' => true,
				'nations_serves' => [:India, :Europe, :NorthAmerica, :Australia, :SouthAmerica]
			}

			obj = Domain.new(options)
			puts obj.nations

		end
	end
end

#hash passed to the Car object
options = { 'wheels' => 4,
			'type' => 'Sports Car',
			'brand' => 'PORSCHE' 
		}

mainObj = Vehicle::Car.new(options)

puts "Wheels => #{mainObj.wheels} \n Car Type => #{mainObj.type} \n Car Brand => #{mainObj.brand}"
puts "NOW ON"
puts mainObj.test
