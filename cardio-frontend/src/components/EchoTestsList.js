import React, {Component} from "react";
import {Button, Container} from "reactstrap";
import {Link, withRouter} from "react-router-dom";
import BootstrapTable from "react-bootstrap-table-next";
import Pagination from "react-js-pagination";


export default class EchoTestsList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            echoTestsList: [],
            columns: [
                {
                    dataField: 'patient_id',
                    text: 'Patient ID'
                },
                {
                    dataField: 'visitDate',
                    text: 'Visit Date'
                },
                {
                    dataField: 'description',
                    text: 'Description'
                }
            ]};

        // this.handlePageChange = this.handlePageChange.bind(this);
        this.fetchEchoTests = this.fetchEchoTests.bind(this);
    }

    componentDidMount () {
        this.setState({isLoading: true});
        this.fetchEchoTests();
    }

    fetchEchoTests(patientsId) {
        fetch(`api/patients/${this.props.patientId ? this.props.patientId : 972}/echotests`)
            .then(response => response.json())
            .then(data => {
                // const totalPages = data.totalPages;
                // const itemsCountPerPage = data.size;
                // const totalItemsCount = data.totalElements;

                this.setState({
                    echoTestsList: data,
                    // totalPages: totalPages,
                    // totalItemsCount: totalItemsCount,
                    // itemsCountPerPage: itemsCountPerPage,
                    isLoading: false
                });

                // console.log(data.content);
                // console.log(this.state.activePage);
                // console.log(this.state.itemsCountPerPage);

            })
            .catch(error => {
                this.setState({error, isLoading: false});
                alert("Could not fetch echotests from database!");
            });
    }

    render() {
        const {isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        // const history = this.props.history;
        //
        // const rowEvents = {
        //     onClick: (e, row, rowIndex) => {
        //         console.log(`clicked on row with index: ${rowIndex}`);
        //         history.push('/patients/' + this.state.patientsList[rowIndex].id);
        //     }
        // };


        return (
            <Container fluid>
                <h1>Echo Tests</h1>
                <div className="table" style={{ marginTop: 50 }}>
                    <BootstrapTable
                        striped
                        hover
                        keyField='id'
                        data={ this.state.echoTestsList }
                        columns={ this.state.columns }
                        // rowEvents={ rowEvents }
                    />
                </div>
            </Container>
        );
    }

}
