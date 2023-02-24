function sendData() {
    const data = document.getElementById('data').value; // Get the value from the input box
    console.log('Data sent successfully:', response.data);
    const apiUrl =  'http://localhost:8080/addemp'; // Replace with the URL of your REST API

    axios.post(apiUrl, { data })
        .then(response => {
            console.log('Data sent successfully:', response.data);
            // Handle the API response as necessary
        })
        .catch(error => {
            console.error('Error sending data:', error);
            // Handle errors as necessary
        });
}
