using System;
using System.Windows;

namespace COCOMO_Calc
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            typeComboBox.SelectedItem = ProjectType.Organic; 
        }

        private void calcButton_Click(object sender, RoutedEventArgs e)
        {
            ProjectType projectType = (ProjectType)typeComboBox.SelectedItem;
            int size = InputToInt32();

            workLabel.Content = $"Трудоємність: {Model.CalculateEfforts(projectType, size):F4}";
            lengthLabel.Content = $"Тривалість: {Model.CalculateTimeDevelop(projectType, size):F4}";
            developersLabel.Content = $"Розробників: {Model.CalculatePersonsToDevelop(projectType, size):F4}";
        }

        private Int32 InputToInt32()
        {
            int size = -1;
            try
            {
                size = Int32.Parse(linesTextBox.Text);
            }
            catch (System.FormatException)
            {
                MessageBox.Show("Введіть число!!!");
            }
            return size;
        }

    }
}
