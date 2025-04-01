async function fetchUserData() {
    try {
        const response = await fetch('http://localhost:8080/user/me');
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        const data = await response.text(); // Expecting a string response
        console.log(data);

        // Display string data on the webpage
        document.getElementById('username').textContent = data;
    } catch (error) {
        console.error('Error fetching user data:', error);
        document.getElementById('username').textContent = 'Failed to fetch user data.';
    }
}

// Call the function on page load
window.onload = fetchUserData;
