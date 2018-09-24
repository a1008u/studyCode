import { ICountriesRepository } from "./icountries-repository";
import { Country } from "./country";
import { Continent } from "./countries-repository";
import { RestCountries } from "./rest-countries";

export class RestCountriesAdapter implements ICountriesRepository{
    constructor(private _restCountriesApi: RestCountries) {}

    private restCountryToCountry(restCountry: any): Country {
        return {
            name: restCountry.name,
            capital: restCountry.capital,
            currency: restCountry.currencies[0].code
        }
    }

    private restCountriesToCountries(restCountries: any[]): Country[] {
        return restCountries
                .map(restCountry => this.restCountryToCountry(restCountry));
    }

    /**
     * 通過情報から国情報の取得
     * @param currency 
     */
    async allByCurrency(currency: string): Promise<Country[]> {
        let restCountries: any[] = await this._restCountriesApi.getByCurrency(currency);
        return this.restCountriesToCountries(restCountries);
    }

    /**
     * 大陸情報から国情報を取得
     * @param continent 
     */
    async allByContinent(continent: Continent): Promise<Country[]> {

        let region = (continent == Continent.NorthAmerica || continent == Continent.SouthAmerica)
                        ? "Americas"
                        :  Continent[continent]
        let restCountries = await this._restCountriesApi.getByRegion(region);

        let result = (continent == Continent.NorthAmerica)
                        ? restCountries.filter(restCountry => restCountry.subregion == "Northern America")
                        : (continent == Continent.SouthAmerica)
                            ? restCountries.filter(restCountry => restCountry.subregion == "South America") 
                            : restCountries
        return this.restCountriesToCountries(result);
    }

    // 未使用
    async all(): Promise<Country[]> {
        let restCountries = await this._restCountriesApi.getAll();
        return this.restCountriesToCountries(restCountries);
    }
}