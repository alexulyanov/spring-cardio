import React, { Component } from 'react';
import { Button, Container } from 'reactstrap';
// import AppNavbar from './AppNavbar';
import { Link, withRouter } from 'react-router-dom'
import Pagination from "react-js-pagination";
import BootstrapTable from 'react-bootstrap-table-next';


class PatientsList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            patientsList: [],
            activePage: 1,
            totalPages: null,
            itemsCountPerPage:null,
            totalItemsCount:null,
            isLoading: true,
            columns: [
                {
                    dataField: 'ohip',
                    text: 'OHIP'
                },
                {
                    dataField: 'firstName',
                    text: 'First Name'
                },
                {
                    dataField: 'lastName',
                    text: 'Last Name'
                },
                {
                    dataField: 'birthDate',
                    text: 'Date of Birth'
                },
                {
                    dataField: 'gender',
                    text: 'Gender'
                },
                {
                    dataField: '',
                    text: 'RefDoctor'
                },
                {
                    dataField: 'mobilePhone',
                    text: 'Phone'
                }

            ]
        };

        this.handlePageChange = this.handlePageChange.bind(this);
        this.fetchPatients = this.fetchPatients.bind(this);
        // this.remove = this.remove.bind(this);

    }

    componentDidMount () {
        this.setState({isLoading: true});
        this.fetchPatients(this.state.activePage);
    }

    handlePageChange(pageNumber) {
        this.setState({activePage: pageNumber});
        this.fetchPatients(pageNumber);

    }

    fetchPatients(page) {
        fetch(`/api/patients?page=${page}&size=35`)
            .then(response => response.json())
            .then(data => {
                const totalPages = data.totalPages;
                const itemsCountPerPage = data.size;
                const totalItemsCount = data.totalElements;

                this.setState({
                    patientsList: data.content,
                    totalPages: totalPages,
                    totalItemsCount: totalItemsCount,
                    itemsCountPerPage: itemsCountPerPage,
                    isLoading: false
                });

                console.log(data.content);
                console.log(this.state.activePage);
                console.log(this.state.itemsCountPerPage);

            })
            .catch(error => {
                this.setState({error, isLoading: false});
                alert("Could not fetch patients from database!");
            });
    }


    render() {
        const {isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const history = this.props.history;

        const rowEvents = {
            onClick: (e, row, rowIndex) => {
                console.log(`clicked on row with index: ${rowIndex}`);
                history.push('/patients/' + this.state.patientsList[rowIndex].id);
            }
        };


        return (
            <Container fluid>
                <div className="float-right">
                    <Button color="btn btn-large btn-success" style={{ marginBottom: 5 }} tag={Link} to="/patients/new">New Patient</Button>
                </div>
                <div className="table" style={{ marginTop: 50 }}>
                    <BootstrapTable
                        striped
                        hover
                        keyField='id'
                        data={ this.state.patientsList }
                        columns={ this.state.columns }
                        rowEvents={ rowEvents }
                    />
                </div>

                <div className="d-flex justify-content-center">
                    <Pagination
                        hideNavigation
                        activePage={this.state.activePage}
                        itemsCountPerPage={this.state.itemsCountPerPage}
                        totalItemsCount={this.state.totalItemsCount}
                        pageRangeDisplayed={10}
                        itemClass='page-item'
                        linkClass='btn btn-light'
                        onChange={this.handlePageChange}
                    />
                </div>
            </Container>
        );
    }
}

export default withRouter(PatientsList);
