import React, { Component } from 'react';
import { Button, Container } from 'reactstrap';
// import AppNavbar from './AppNavbar';
import { Link, withRouter } from 'react-router-dom'
import Pagination from "react-js-pagination";
import BootstrapTable from 'react-bootstrap-table-next';
import EchoTestsList from "./EchoTestsList";
import TablePagination from "@material-ui/core/TablePagination";


class PatientsList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            patientsList: [],
            activePage: 0,
            totalPages: null,
            itemsCountPerPage:null,
            rowsPerPage: 25,
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
        this.fetchPatients(this.state.activePage, this.state.rowsPerPage);
    }

    handlePageChange(event, pageNumber) {
        this.setState({activePage: pageNumber});
        this.fetchPatients(pageNumber, this.state.rowsPerPage);

    }

    handleChangeRowsPerPage = (event) => {
        this.setState({activePage: 0, rowsPerPage: parseInt(event.target.value)});
        this.fetchPatients(0, parseInt(event.target.value));

    };

    fetchPatients(page, size) {
        fetch(`/api/patients?page=${page}&size=${size}`)
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
                // history.push('/patients/' + this.state.patientsList[rowIndex].id);

            }
        };


        return (
            <div>
                <Container fluid>
                    <div className="float-right">
                        <Button color="btn btn-large btn-success" style={{marginBottom: 5}} tag={Link}
                                to="/patients/new">New Patient</Button>
                    </div>
                    <div className="table" style={{marginTop: 50}}>
                        <BootstrapTable
                            striped
                            hover
                            keyField='id'
                            data={this.state.patientsList}
                            columns={this.state.columns}
                            noDataIndication="Table is Empty"
                            rowEvents={rowEvents}
                        />
                    </div>

                    <div className="d-flex justify-content-center">
                        {/*<Pagination*/}
                        {/*    // hideNavigation*/}
                        {/*    activePage={this.state.activePage}*/}
                        {/*    itemsCountPerPage={this.state.itemsCountPerPage}*/}
                        {/*    totalItemsCount={this.state.totalItemsCount}*/}
                        {/*    pageRangeDisplayed={10}*/}
                        {/*    itemClass='page-item'*/}
                        {/*    linkClass='btn btn-light'*/}
                        {/*    onChange={this.handlePageChange}*/}
                        {/*/>*/}
                        <TablePagination
                            component="div"
                            count={this.state.totalItemsCount}
                            page={this.state.activePage}
                            onChangePage={this.handlePageChange}
                            // rowsPerPage={this.state.itemsCountPerPage}
                            rowsPerPage={this.state.rowsPerPage}
                            onChangeRowsPerPage={this.handleChangeRowsPerPage}
                        />
                    </div>
                </Container>
                <EchoTestsList patientId={995}/>
            </div>
        );
    }
}

export default withRouter(PatientsList);
