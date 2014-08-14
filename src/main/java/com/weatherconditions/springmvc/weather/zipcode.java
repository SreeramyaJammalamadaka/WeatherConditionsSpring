package com.weatherconditions.springmvc.weather;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.stereotype.Component;

@Component 
@JsonIgnoreProperties(ignoreUnknown = true)
public class zipcode {
	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class Observation {

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Location {
            private String city;
            private String state;
            private String zip;

            /**
			 * @return the zip
			 */
			public String getZip() {
				return zip;
			}

			/**
			 * @param zip the zip to set
			 */
			public void setZip(String zip) {
				this.zip = zip;
			}

			public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }
        }
        @JsonProperty("display_location")
        private Location displayLocation;

        public Location getDisplayLocation() {
            return displayLocation;
        }

        public void setDisplayLocation(Location displayLocation) {
            this.displayLocation = displayLocation;
        }

        @JsonProperty("temp_f")
        private String currentTemperature;

        public String getCurrentTemperature() {
            return currentTemperature;
        }

        public void setCurrentTemperature(String currentTemperature) {
            this.currentTemperature = currentTemperature;
        }
    }

    @JsonProperty("current_observation")
    private Observation currentObservation;



    public Observation getCurrentObservation() {
        return currentObservation;
    }

    public void setCurrentObservation(Observation currentObservation) {
        this.currentObservation = currentObservation;
    }
}
