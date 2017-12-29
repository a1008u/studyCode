export class ajson{

    private _user:String
    private _text:String
    private _profileImageUrl:String
    private _createdAt:String

    constructor(user: String, text: String, profileImageUrl: String, createdAt: String) {
        this._user = user;
        this._text = text;
        this._profileImageUrl = profileImageUrl;
        this._createdAt = createdAt;
    }


    get user(): String {
        return this._user;
    }

    set user(value: String) {
        this._user = value;
    }

    get text(): String {
        return this._text;
    }

    set text(value: String) {
        this._text = value;
    }

    get profileImageUrl(): String {
        return this._profileImageUrl;
    }

    set profileImageUrl(value: String) {
        this._profileImageUrl = value;
    }

    get createdAt(): String {
        return this._createdAt;
    }

    set createdAt(value: String) {
        this._createdAt = value;
    }
}