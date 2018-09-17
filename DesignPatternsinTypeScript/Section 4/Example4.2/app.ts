import { CountriesRepository, Continent } from "./countries-repository";
import { RestCountries } from "./rest-countries";
import { RestCountriesAdapter } from "./rest-countries-adapter";

// let countriesRepo = new CountriesRepository();
let countriesRepo = new RestCountriesAdapter(new RestCountries());

countriesRepo
    .allByCurrency("EUR")
    .then(euroCountries => {
        console.log("Euro countries: ", euroCountries);
    });

countriesRepo
    .allByContinent(Continent.NorthAmerica)
    .then(northAmerica => {
        console.log(`Number of north american countries stored: ${northAmerica.length}`);
    });


// Demo code


// let restCountries = new RestCountries();
// restCountries
//    .getByRegion("Americas")
//    .then(northAmericaCountries => {
//      console.log(`Number of north america countries: ${northAmericaCountries.length}`);
//    });