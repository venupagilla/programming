#!/usr/bin/env python
import warnings

from datetime import datetime

from research_and_blog_crew.crew import ResearchAndBlogCrew

warnings.filterwarnings("ignore", category=SyntaxWarning, module="pysbd")

# This main file is intended to be a way for you to run your
# crew locally, so refrain from adding unnecessary logic into this file.
# Replace with inputs you want to test with, it will automatically
# interpolate any tasks and agents information

def run():
    """
    Run the crew.
    """
    inputs = {
        'topic': 'Cognitive ability of llm',
        'current_year': str(datetime.now().year)
    }

    try:
        ResearchAndBlogCrew().crew().kickoff(inputs=inputs)
    except Exception as e:
        raise Exception(f"An error occurred while running the crew: {e}")


if __name__ == "__main__":
    # Allow `python main.py` to run the crew directly.
    run()


