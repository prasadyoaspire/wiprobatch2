import React from 'react';
class RegForm extends React.Component {
    constructor(props) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.name = React.createRef();
        this.age = React.createRef();
    }

    handleSubmit(event) {        
        alert('Name ' + this.name.current.value+ ' Age '+this.age.current.value);       
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <div>
                    <label>
                        Name:
                        <input type="text" ref={this.name} />
                    </label>
                </div>
                <div>
                    <label>
                        Age:
                        <input type="text" ref={this.age} />
                    </label>
                </div>

                <input type="submit" value="Submit" />
            </form>
        );
    }
}

export default RegForm;