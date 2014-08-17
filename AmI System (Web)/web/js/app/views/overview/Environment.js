/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
var path = "../jp373/js/app/views/overview/Environment";

define(path, function(environment) {
    function Environment() {
        
        /**
         * Displays an overview of the temperature for both agents in the form of a chart graph(?)
         */
        this.displayTemperatureOverview = function() {
            // system history
            require(['../jp373/js/app/views/overview/temperature/TemperatureOverview'], function(temperatureOverview) {
                temperatureOverview.display();
            });
        };
        
    };
    
    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new Environment();
});