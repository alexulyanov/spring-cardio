import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';

class PatientEdit extends Component {

    emptyItem = {
        ohip: '',
        firstName: '',
        lastName: '',
        gender: '',
        birthDate: '',
        address: '',
        city: '',
        province: '',
        postalCode: '',
        mobilePhone: ''
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

     async componentDidMount() {
        if (this.props.match.params.id !== 'new') {
            const patient = await (await fetch(`/api/patients/${this.props.match.params.id}`)).json();
            this.setState({item: patient});
        }
    }


    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
    }

    async handleSubmit(event) {
        event.preventDefault();
        const {item} = this.state;

        await fetch('/api/patients' + (item.id ? '/' + item.id : ''), {
            method: (item.id) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        })
            .then(result => {
                if (!result.ok) throw result;
                return result.json();
            })
            .then(result => {
                console.log(result);
                this.setState({
                    isLoaded: true,
                    error: null
                });
                alert("Patient saved!")
            })
            .catch(error => {
                console.log("Error occurred");
                alert("Could not save patient.")
                error.json().then(body => {
                    //Here is already the payload from API
                    console.log(body);
                    console.log("message = " + body.message);
                    this.setState({
                        isLoaded: true,
                        error: body
                    });
                });
            });

        this.props.history.push('/');
    }

    render() {
        const {item} = this.state;
        const title = <h2>{item.id ? 'Edit Patient' : 'Add Patient'}</h2>;

        return(
            <div>
                <Container fluid>
                    {title}
                    <Form onSubmit={this.handleSubmit}>
                        <div className="row">
                            <FormGroup className="col-md-1 mb-3">
                                <Label for="name">OHIP</Label>
                                <Input type="text" name="ohip" id="ohip" value={item.ohip || ''}
                                       onChange={this.handleChange} autoComplete="ohip"/>
                            </FormGroup>
                            <FormGroup className="col-md-4 mb-3">
                                <Label for="address">First Name</Label>
                                <Input type="text" name="firstName" id="firstName" value={item.firstName || ''}
                                       onChange={this.handleChange} autoComplete="name"/>
                            </FormGroup>
                            <FormGroup className="col-md-4 mb-3">
                                <Label for="city">Last Name</Label>
                                <Input type="text" name="lastName" id="lastName" value={item.lastName || ''}
                                       onChange={this.handleChange} autoComplete="address-level1"/>
                            </FormGroup>
                            <FormGroup className="col-md-1 mb-3">
                                <Label for="gender">Gender</Label>
                                <Input type="select" name="gender" id="gender" value={item.gender || 'Not Selected'} onChange={this.handleChange}>
                                    <option>Not Selected</option>
                                    <option>Male</option>
                                    <option>Female</option>
                                </Input>
                            </FormGroup>
                            <FormGroup className="col-md-2 mb-2">
                                <Label for="birthDate">Date of Birth</Label>
                                <Input
                                    onChange={this.handleChange}
                                    value={item.birthDate || 'Not Selected'}
                                    type="date"
                                    name="birthDate"
                                    id="birthDate"
                                    placeholder="Not Selected"
                                />
                            </FormGroup>
                        </div>
                        <div className="row">
                            <FormGroup className="col-md-4 mb-3">
                                <Label for="country">Address</Label>
                                <Input type="text" name="address" id="address" value={item.address || ''}
                                       onChange={this.handleChange} autoComplete="address-level1"/>
                            </FormGroup>
                            <FormGroup className="col-md-2 mb-3">
                                <Label for="stateOrProvince">State/Province</Label>
                                <Input type="text" name="province" id="province" value={item.province || ''}
                                       onChange={this.handleChange} autoComplete="address-level1"/>
                            </FormGroup>
                            <FormGroup className="col-md-2 mb-3">
                                <Label for="country">City</Label>
                                <Input type="text" name="city" id="city" value={item.city || ''}
                                       onChange={this.handleChange} autoComplete="address-level1"/>
                            </FormGroup>
                            <FormGroup className="col-md-2 mb-3">
                                <Label for="country">Postal Code</Label>
                                <Input type="text" name="postalCode" id="postalCode" value={item.postalCode || ''}
                                       onChange={this.handleChange} autoComplete="address-level1"/>
                            </FormGroup>
                            <FormGroup className="col-md-2 mb-3">
                                <Label for="country">Phone</Label>
                                <Input type="text" name="mobilePhone" id="mobilePhone" value={item.mobilePhone || ''}
                                       onChange={this.handleChange} autoComplete="phone"/>
                            </FormGroup>
                        </div>
                        <FormGroup>
                            <Button color="primary" type="submit">Save</Button>{' '}
                            <Button color="secondary" tag={Link} to="/">Cancel</Button>
                        </FormGroup>
                    </Form>
                </Container>
            </div>
        );
    }
}

export default PatientEdit;
